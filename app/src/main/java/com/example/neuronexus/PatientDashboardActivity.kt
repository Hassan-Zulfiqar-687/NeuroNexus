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

        // 1. Setup Navigation Controller
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // 2. Link BottomNavView with NavController
        // CHANGE: Use 'bottomNavView', not 'bottomAppBar'
        binding.bottomNavView.setupWithNavController(navController)

        // 3. Handle Menu Clicks (Hybrid Approach)
        // CHANGE: Method name is setOnItemSelectedListener
        binding.bottomNavView.setOnItemSelectedListener { menuItem ->

            if (menuItem.itemId == R.id.navigation_more) {
                // SPECIAL CASE: Open the "More" Bottom Sheet
                val bottomSheet = PatientMoreFragment()
                bottomSheet.show(supportFragmentManager, "PatientMoreFragment")

                // Return FALSE because we don't want the "More" icon to stay selected/highlighted
                false
            } else {
                // STANDARD CASE: Let NavigationUI handle Home, Schedule, Lab
                NavigationUI.onNavDestinationSelected(menuItem, navController)

                // Return TRUE to highlight the selected icon (Home/Schedule/Lab)
                true
            }
        }

        // 4. FAB Click Listener
        binding.fab.setOnClickListener {
            Toast.makeText(this, "Quick Booking Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}