package com.example.neuronexus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpRoleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up_role)

        val btn_doctor = findViewById<Button>(R.id.btn_doctor_role)
        val btn_patient = findViewById<Button>(R.id.btn_patient_role)

        btn_doctor.setOnClickListener {
            val intent = Intent(this, DoctorSignUpActivity::class.java)
            startActivity(intent)
        }

        btn_patient.setOnClickListener {
            val intent = Intent(this, PatientSignUpActivity::class.java)
            startActivity(intent)
        }
    }

}