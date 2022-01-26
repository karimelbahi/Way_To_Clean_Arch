package com.example.task.presentation.ui.scanproduct

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.SurfaceHolder
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.task.R
import com.example.task.data.local.database.model.ProductDB
import com.example.task.databinding.FragmentScanProductBinding
import com.example.task.domain.entity.Product
import com.example.task.presentation.utils.*
import com.example.task.presentation.utils.Constants.ALLOWED_DIFF_DAYS
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.barcode.Barcode
import com.google.android.gms.vision.barcode.BarcodeDetector
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException
import java.util.*

@AndroidEntryPoint
class ScanProductFragment : Fragment(R.layout.fragment_scan_product) {

    val viewModel: ScanProductViewModel by viewModels()

    private lateinit var cameraSource: CameraSource
    private lateinit var barcodeDetector: BarcodeDetector
    private var scannedValue = ""
    private var permissionGranted = false
    private lateinit var radio: RadioButton
    private var _binding: FragmentScanProductBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentScanProductBinding.bind(view)

        binding.typeRg.setOnCheckedChangeListener { _, checkedId ->
            if (binding.typeRg.checkedRadioButtonId != -1) {
                radio = requireActivity().findViewById(checkedId)
            }
        }

        setupCamera()
        binding.addProductBtn.setOnClickListener {
            val customCalendar = Calendar.getInstance()
            customCalendar.set(
                binding.dateP.year,
                binding.dateP.month,
                binding.dateP.dayOfMonth,
                binding.timeP.hour,
                binding.timeP.minute
            )

            if (diffDaysBetweenTwoTimes(
                    customCalendar.timeInMillis,
                    currentTime()
                ) > ALLOWED_DIFF_DAYS
            ) {

                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle(R.string.expired_date_warn)
                builder.setMessage(R.string.mocking_message)
                builder.setIcon(android.R.drawable.ic_dialog_alert)

                //performing yes action
                builder.setPositiveButton(getString(R.string.yes)) { _, _ ->
                    val mockedDate = customCalendar.timeInMillis.mockDate(requireContext())
                    insertProduct(mockedDate)
                }
                //performing cancel action
                builder.setNeutralButton(getString(R.string.edit_date)) { _, _ ->

                }
                //performing negative action
                builder.setNegativeButton(getString(R.string.no)) { _, _ ->
                    insertProduct(customCalendar.timeInMillis)
                }
                val alertDialog: AlertDialog = builder.create()
                alertDialog.setCancelable(false)
                alertDialog.show()

            } else {
                insertProduct(customCalendar.timeInMillis)
            }
        }
        setObservers()
    }


    private fun insertProduct(expiryDate: Long) {
        viewModel.insertProduct(
            Product(
                code = binding.productCodeEt.text.toString(),
                name = binding.productNameEt.text.toString(),
                type = if (::radio.isInitialized) radio.text.toString() else "",
                expiredDate = expiryDate
            )
        )
    }

    private fun setObservers() {

        viewModel.productCode.observe(viewLifecycleOwner, {
            binding.progressCircular.gone()
            if (it.isBlank())
                binding.productCodeIl.error = null
            else
                binding.productCodeIl.error = it
        })
        viewModel.productName.observe(viewLifecycleOwner, {
            binding.progressCircular.gone()
            if (it.isBlank())
                binding.productNameIl.error = null
            else
                binding.productNameIl.error = it
        })
        viewModel.productType.observe(viewLifecycleOwner, {
            binding.progressCircular.gone()
            if (it.isNotEmpty())
                showToast(it)
        })
        viewModel.productCode.observe(viewLifecycleOwner, {
            binding.progressCircular.gone()
            if (it.isNotEmpty())
                showToast(it)
        })
        viewModel.productDate.observe(viewLifecycleOwner, {
            showToast(it)
        })
        viewModel.insertEvent.observe(viewLifecycleOwner, {
            binding.progressCircular.gone()
            showToast(it)
        })
    }

    private fun showSnack(message: String) {
        binding.main.snack(message) {}
    }

    private fun showToast(message: String) {
        requireActivity().toast(message)
    }

    private fun setupCamera() {
        cameraPermission.launch(Manifest.permission.CAMERA)

        // animate recognition line
        val aniSlide: Animation =
            AnimationUtils.loadAnimation(requireActivity(), R.anim.scanner_blink_animation)
        binding.barcodeRecognitionView.startAnimation(aniSlide)
    }

    private val cameraPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            with(binding.root) {
                when {
                    granted -> {
                        permissionGranted = true
                        setupControls()
                    }
                    shouldShowRequestPermissionRationale(Manifest.permission.CAMERA) -> {
                        permissionGranted = false
                    }
                    else -> {
                        permissionGranted = false
                    }
                }
            }
        }



    private fun setupControls() {
        barcodeDetector =
            BarcodeDetector.Builder(requireActivity()).setBarcodeFormats(Barcode.ALL_FORMATS)
                .build()

        cameraSource = CameraSource.Builder(requireActivity(), barcodeDetector)
            .setRequestedPreviewSize(1920, 1080)
            .setAutoFocusEnabled(true) //you should add this feature
            .build()

        binding.svBarcode.holder.addCallback(object : SurfaceHolder.Callback {
            @SuppressLint("MissingPermission")
            override fun surfaceCreated(holder: SurfaceHolder) {
                try {
                    //Start preview after 1s delay
                    cameraSource.start(holder)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            @SuppressLint("MissingPermission")
            override fun surfaceChanged(
                holder: SurfaceHolder,
                format: Int,
                width: Int,
                height: Int
            ) {
                try {
                    cameraSource.start(holder)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                cameraSource.stop()
            }
        })


        barcodeDetector.setProcessor(object : Detector.Processor<Barcode> {
            override fun release() {
                Toast.makeText(requireActivity(), "Scanner has been closed", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun receiveDetections(detections: Detector.Detections<Barcode>) {
                val barcodes = detections.detectedItems
                if (barcodes.size() == 1) {
                    scannedValue = barcodes.valueAt(0).rawValue
                    cameraSource.stop()

                    //Don't forget to add this line printing value or finishing activity must run on main thread
                    requireActivity().runOnUiThread {
                        binding.productCodeEt.setText(scannedValue)
                    }
                } else {
                    Log.i("infoLog","ScanProductFragment, receiveDetections , 251")
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        setupControls()
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraSource.stop()
        cameraSource.release()
        _binding = null
    }

}

