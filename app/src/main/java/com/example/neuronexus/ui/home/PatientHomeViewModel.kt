package com.example.neuronexus.ui.home

import androidx.lifecycle.ViewModel
import com.example.neuronexus.models.PatientDashboardService
import com.example.neuronexus.R

class PatientHomeViewModel : ViewModel() {

    fun getServiceList(): List<PatientDashboardService> {
        return listOf(
            PatientDashboardService("Heart Surgeon", R.drawable.heart),
            PatientDashboardService("Dentistry", R.drawable.tooth),
            PatientDashboardService("Neurology", R.drawable.brain),
            PatientDashboardService("Orthopedic", R.drawable.orthopedics)
        )
    }
}