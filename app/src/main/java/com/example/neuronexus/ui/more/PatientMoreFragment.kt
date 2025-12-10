package com.example.neuronexus.ui.more

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.neuronexus.LoginActivity
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
            // 1. Close the Bottom Sheet (The popup)
            dismiss()

            // 2. Find the Main Activity's Navigation Controller
            // We are looking for the 'nav_host_fragment' that lives in PatientDashboardActivity
            val navController = androidx.navigation.Navigation.findNavController(
                requireActivity(),
                R.id.nav_host_fragment
            )

            // 3. Navigate to the Profile Fragment
            navController.navigate(R.id.navigation_profile)
        }

        binding.btnHistory.setOnClickListener {
            dismiss()

            androidx.navigation.Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.navigation_patient_history)
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
        // 1. Clear Local Data (CRITICAL)
        // You still must do this, otherwise the app "forgets" the UI
        // but remembers the data in the background.
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