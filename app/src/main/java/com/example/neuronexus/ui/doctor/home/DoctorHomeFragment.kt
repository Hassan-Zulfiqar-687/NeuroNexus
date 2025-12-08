package com.example.neuronexus.ui.doctor.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.neuronexus.R
import com.example.neuronexus.adapters.DoctorAppointmentAdapter
import com.example.neuronexus.databinding.FragmentDoctorHomeBinding
import com.example.neuronexus.models.DoctorAppointmentItem

class DoctorHomeFragment : Fragment() {

    private var _binding: FragmentDoctorHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoctorHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupQuickAccess()
        setupAppointmentsList()
    }

    private fun setupQuickAccess() {
        // Detect Tumor
        binding.cardDetectTumor.tvTitle.text = "Detect Tumor"
        binding.cardDetectTumor.imgIcon.setImageResource(R.drawable.brain_tumor)
        binding.cardDetectTumor.root.setOnClickListener {
            Toast.makeText(context, "Opening Tumor Detection...", Toast.LENGTH_SHORT).show()
        }

        // History
        binding.cardHistory.tvTitle.text = "History"
        binding.cardHistory.imgIcon.setImageResource(R.drawable.history)
        binding.cardHistory.root.setOnClickListener {
            Toast.makeText(context, "Opening History...", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupAppointmentsList() {

        val appointments = listOf(
            DoctorAppointmentItem("Margret Osborn", "8:30 am", R.drawable.patient),
            DoctorAppointmentItem("John Doe", "9:00 am", R.drawable.patient), // Use actual images if you have them
            DoctorAppointmentItem("Sarah Smith", "10:15 am", R.drawable.patient),
            DoctorAppointmentItem("David Lee", "11:30 am", R.drawable.patient),
            DoctorAppointmentItem("Emma Watson", "2:00 pm", R.drawable.patient),
            DoctorAppointmentItem("Chris Evans", "3:45 pm", R.drawable.patient)
        )

        val adapter = DoctorAppointmentAdapter(appointments)

        binding.rvAppointments.layoutManager = GridLayoutManager(context, 2) // 2 Columns
        binding.rvAppointments.adapter = adapter

        binding.rvAppointments.isNestedScrollingEnabled = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}