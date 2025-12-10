package com.example.neuronexus.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.neuronexus.databinding.FragmentPatientEditProfileBinding

class PatientEditProfileFragment : Fragment() {

    private var _binding: FragmentPatientEditProfileBinding? = null
    // This property is valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: PatientEditProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(PatientEditProfileViewModel::class.java)
        _binding = FragmentPatientEditProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etName.setText("Alex Martines")
        binding.etEmail.setText("alex.martines@gmail.com")
        binding.etPhone.setText("+92 300 1234567")
        binding.etCnic.setText("42101-1234567-1")
        binding.etPassword.setText("123456")

        // 2. Handle Back Button
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        // 3. Handle Save Button
        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val phone = binding.etPhone.text.toString()
            val pass = binding.etPassword.text.toString()

            // Trigger ViewModel logic
            viewModel.saveChanges(name, phone, pass)
        }

        // 4. Handle Camera Click
        binding.btnChangePhoto.setOnClickListener {
            Toast.makeText(context, "Open Gallery...", Toast.LENGTH_SHORT).show()
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        // Success Observer
        viewModel.saveStatus.observe(viewLifecycleOwner) { isSuccess ->
            if (isSuccess) {
                Toast.makeText(context, "Profile Updated Successfully!", Toast.LENGTH_SHORT).show()
                // Go back to the View Profile screen
                findNavController().navigateUp()
            }
        }

        // Error Observer
        viewModel.errorMessage.observe(viewLifecycleOwner) { error ->
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}