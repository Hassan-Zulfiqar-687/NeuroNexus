package com.example.neuronexus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.neuronexus.databinding.ActivityDoctorDashboardBinding
import com.example.neuronexus.ui.doctor.more.DoctorMoreFragment

class DoctorDashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoctorDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_doctor) as NavHostFragment
        val navController = navHostFragment.navController

        binding.doctorBottomNav.setupWithNavController(navController)

        binding.doctorBottomNav.setOnItemSelectedListener { menuItem ->

            if (menuItem.itemId == R.id.navigation_doctor_more) {
                val bottomSheet = DoctorMoreFragment()
                bottomSheet.show(supportFragmentManager, "DoctorMoreFragment")
                false
            } else {
                NavigationUI.onNavDestinationSelected(menuItem, navController)
                true
            }
        }
    }
}