package com.example.neuronexus.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.neuronexus.R
import com.example.neuronexus.databinding.FragmentPatientProfileBinding

class PatientProfileFragment : Fragment() {

    private var _binding: FragmentPatientProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PatientProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(PatientProfileViewModel::class.java)

        _binding = FragmentPatientProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 2. Observer Data (MVVM)
        viewModel.userName.observe(viewLifecycleOwner) { name ->
            binding.tvName.text = name
        }
        viewModel.userEmail.observe(viewLifecycleOwner) { email ->
            binding.tvEmail.text = email
        }
        viewModel.userContact.observe(viewLifecycleOwner) { contact ->
            binding.tvPhone.text = contact
        }
        viewModel.userCnic.observe(viewLifecycleOwner) { cnic ->
            binding.tvCnic.text = cnic
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnEditProfile.setOnClickListener {
            findNavController().navigate(R.id.navigation_edit_profile)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}