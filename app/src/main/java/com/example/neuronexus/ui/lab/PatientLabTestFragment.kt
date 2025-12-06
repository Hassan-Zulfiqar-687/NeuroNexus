package com.example.neuronexus.ui.lab

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.neuronexus.R

class PatientLabTestFragment : Fragment() {

    companion object {
        fun newInstance() = PatientLabTestFragment()
    }

    private val viewModel: PatientLabTestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_patient_lab_test, container, false)
    }
}