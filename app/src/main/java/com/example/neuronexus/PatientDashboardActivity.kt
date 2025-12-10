package com.example.neuronexus

import android.os.Bundle
import android.view.View
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
        binding.bottomNavView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->

            val params = binding.navHostFragment.layoutParams as androidx.coordinatorlayout.
            widget.CoordinatorLayout.LayoutParams
            val density = resources.displayMetrics.density // To convert dp to pixels

            when (destination.id) {
                R.id.navigation_home,
                R.id.navigation_schedule,
                R.id.navigation_lab -> {
                    // 1. Show the Bottom Bar parts
                    binding.bottomNavView.visibility = View.VISIBLE
                    binding.bottomAppBar.visibility = View.VISIBLE
                    binding.fab.show()

                    params.bottomMargin = (60 * density).toInt()
                }
                else -> {
                    binding.bottomNavView.visibility = View.GONE
                    binding.bottomAppBar.visibility = View.GONE
                    binding.fab.hide()

                    // 2. REMOVE the Margin so the screen goes to the very bottom
                    params.bottomMargin = 0
                }
            }
            // Apply the updated params
            binding.navHostFragment.layoutParams = params
        }

        binding.bottomNavView.setOnItemSelectedListener { menuItem ->
            if (menuItem.itemId == R.id.navigation_more) {
                // Open Bottom Sheet
                val bottomSheet = PatientMoreFragment()
                bottomSheet.show(supportFragmentManager, "PatientMoreFragment")
                false
            } else {
                // Navigate to standard tabs
                NavigationUI.onNavDestinationSelected(menuItem, navController)
                true
            }
        }

        // 5. FAB Click Listener
        binding.fab.setOnClickListener {
            Toast.makeText(this, "Quick Booking Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}