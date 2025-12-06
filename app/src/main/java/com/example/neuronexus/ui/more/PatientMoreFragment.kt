package com.example.neuronexus.ui.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.neuronexus.R
import com.example.neuronexus.databinding.FragmentPatientMoreBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PatientMoreFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentPatientMoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPatientMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnProfile.setOnClickListener {
            Toast.makeText(context, "Opening Profile...", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        binding.btnAppointment.setOnClickListener {
            Toast.makeText(context, "Opening Appointments...", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        binding.btnSettings.setOnClickListener {
            Toast.makeText(context, "Opening Settings...", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        binding.btnHelp.setOnClickListener {
            Toast.makeText(context, "Opening Help...", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        binding.btnLogout.setOnClickListener {
            Toast.makeText(context, "Logging Out...", Toast.LENGTH_SHORT).show()
            // Add your logout logic here (e.g., clear data, go to login screen)
            dismiss()
        }
    }

    // --- ESSENTIAL FOR ROUNDED CORNERS ---
    // This applies the transparent background theme we added earlier.
    // If you skip this, the sheet might have white corners behind your blue rounded drawable.
    override fun getTheme(): Int {
        return R.style.BottomSheetDialogTheme
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}