package com.example.neuronexus

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.neuronexus.databinding.ActivityPatientDashboardBinding
import com.example.neuronexus.ui.more.PatientMoreFragment

class PatientDashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPatientDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatientDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavView.setupWithNavController(navController)

        binding.bottomNavView.setOnItemSelectedListener { menuItem ->

            if (menuItem.itemId == R.id.navigation_more) {
                val bottomSheet = PatientMoreFragment()
                bottomSheet.show(supportFragmentManager, "PatientMoreFragment")
                false
            } else {
                NavigationUI.onNavDestinationSelected(menuItem, navController)

                true
            }
        }

        // 4. FAB Click Listener
        binding.fab.setOnClickListener {
            Toast.makeText(this, "Quick Booking Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}