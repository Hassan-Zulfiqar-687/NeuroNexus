package com.example.neuronexus.ui.doctor.more

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.neuronexus.LoginActivity
import com.example.neuronexus.R
import com.example.neuronexus.databinding.FragmentDoctorMoreBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DoctorMoreFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentDoctorMoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoctorMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnProfile.setOnClickListener {
            // 1. Close the Bottom Sheet
            dismiss()

            // 2. Find the *Doctor* Activity's Navigation Controller
            // Note: We use 'nav_host_fragment_doctor' here!
            androidx.navigation.Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_doctor)
                .navigate(R.id.navigation_doctor_profile)
        }

        binding.btnHistory.setOnClickListener {
            Toast.makeText(context, "Opening History...", Toast.LENGTH_SHORT).show()
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
            performLogout()
        }
    }

    private fun performLogout() {

        val sharedPref = requireActivity().getSharedPreferences("UserSession", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.clear()
        editor.apply()

        val intent = Intent(requireActivity(), LoginActivity::class.java)
        startActivity(intent)

        requireActivity().finishAffinity()
    }

    override fun getTheme(): Int {
        return R.style.BottomSheetDialogTheme
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}