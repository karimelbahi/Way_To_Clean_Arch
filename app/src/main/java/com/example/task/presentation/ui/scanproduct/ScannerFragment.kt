package com.example.task.presentation.ui.scanproduct

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import com.example.task.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.budiyev.android.codescanner.*
import com.example.task.databinding.FragmentScannerBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ScannerFragment : Fragment() {
    private lateinit var binding: FragmentScannerBinding
    private lateinit var codeScanner: CodeScanner
    private var permissionGranted = false
    lateinit var navController: NavController
    lateinit var barcode: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScannerBinding.inflate(inflater)
//        binding.lifecycleOwner = this
        val navHostFragment = activity?.supportFragmentManager
            ?.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        codeScanner = CodeScanner(requireContext(), binding.scannerView)

        cameraPermission.launch(Manifest.permission.CAMERA)
    }

    private fun scan() {
        codeScanner.apply {
            camera = CodeScanner.CAMERA_BACK
            formats = CodeScanner.ALL_FORMATS
            autoFocusMode = AutoFocusMode.SAFE
            scanMode = ScanMode.CONTINUOUS
            isAutoFocusEnabled = true
            isFlashEnabled = false
            decodeCallback = DecodeCallback {
                requireActivity().runOnUiThread {
                    Toast.makeText(
                        context,
                        it.text,
                        Toast.LENGTH_SHORT
                    ).show()
                    it.text?.let { barcode ->
                        navigateToDetails(barcode)
                    }
                }

            }
            errorCallback = ErrorCallback {
                requireActivity().runOnUiThread {
                    Toast.makeText(
                        context,
                        "Something went wrong, please try again",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.e("Scanner", "Camera initialization error : ${it.message}")
                }
            }


        }
        codeScanner.startPreview()
    }

    override fun onPause() {
        super.onPause()
        codeScanner.releaseResources()
    }

    override fun onResume() {
        super.onResume()
        Log.e("karimDebug", "${permissionGranted}ScannerFragment, onResume , 109");
        if (permissionGranted)
            codeScanner.startPreview()
        if (ContextCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.CAMERA
            )
            == PackageManager.PERMISSION_GRANTED
        )
            Log.e("karimDebug", "truuuuuScannerFragment, onResume , 120");

    }

    private val cameraPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            with(binding.root) {
                when {
                    granted -> {
                        permissionGranted = true
                        scan()
                    }


                    shouldShowRequestPermissionRationale(Manifest.permission.CAMERA) -> {
                        Toast.makeText(
                            requireContext(),
                            resources.getString(R.string.permissionx_manage_external_storage),
                            Toast.LENGTH_SHORT
                        ).show()
                        permissionGranted = false
                    }
                    else -> {
                        Toast.makeText(
                            requireContext(),
                            resources.getString(R.string.permissionx_access_background_location),
                            Toast.LENGTH_SHORT
                        ).show()
                        permissionGranted = false
                    }
                }
            }
        }

    private fun navigateToDetails(barcode: String) {
//        val action =
//            ScannerFragmentDirections.actionScannerFragmentToProductDetailsFragment(barcode = barcode)
//        if (navController.currentDestination?.id == R.id.navigation_scan_barcode)
//            navController.navigate(action)
    }

}