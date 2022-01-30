package com.example.task.presentation.ui.freshproducts

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task.R
import com.example.task.databinding.FragmentFreshProductsBinding
import com.example.task.presentation.utils.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ObsoleteCoroutinesApi
import javax.inject.Inject

@AndroidEntryPoint
class FreshProductsFragment : Fragment(R.layout.fragment_fresh_products) {

    val viewModel: FreshProductsViewModel by viewModels()

    private var _binding: FragmentFreshProductsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var freshProductsAdapter: FreshProductsAdapter

    @ObsoleteCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFreshProductsBinding.bind(view)

        setUpViews()
        setObservers()
        Log.e("karimDebug","FreshProductsFragment, onViewCreated , 34");

    }

    private fun setUpViews() {

        binding.apply {
            progressCircular.visibility = View.VISIBLE
            recyclerViewCountries.apply {
                adapter = freshProductsAdapter
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                setHasFixedSize(true)
                itemAnimator = null
            }
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.getFreshProducts()

    }

    @ObsoleteCoroutinesApi
    private fun setObservers() {

        binding.progressCircular.visible()
        viewModel.products.observe(viewLifecycleOwner, { products ->
            when (products.status) {
                Resource.Status.LOADING -> {
                    binding.progressCircular.visible()
                }
                Resource.Status.ERROR -> {
                    binding.progressCircular.invisible()
                    products.message?.let {
                        showToast(it)
                    }
                }
                Resource.Status.SUCCESS -> {
                    binding.progressCircular.invisible()
                    if (products.data.isNullOrEmpty()) {
                        binding.emptyBoxImg.visible()
                        products.message?.let { showToast(it) }
                    } else {
                        binding.emptyBoxImg.gone()
                        freshProductsAdapter.submitList(products.data)
                    }
                }
            }
        })
    }

    private fun showSnackBar(message: String) {
        binding.main.snack(message) {}
    }

    private fun showToast(message: String) {
        requireActivity().toast(message)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

