package com.example.neuronexus

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.neuronexus.databinding.ActivitySignUpRoleBinding

class SignUpRoleActivity : AppCompatActivity() {

    private var _binding: ActivitySignUpRoleBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySignUpRoleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnDoctorRole.setOnClickListener {
            val intent = Intent(this, DoctorSignUpActivity::class.java)
            startActivity(intent)
        }

        binding.btnPatientRole.setOnClickListener {
            val intent = Intent(this, PatientSignUpActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}