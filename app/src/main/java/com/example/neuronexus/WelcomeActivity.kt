package com.example.neuronexus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeActivity : AppCompatActivity() {
    private lateinit var btn_login: Button
    private lateinit var btn_signup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

        btn_login = findViewById<Button>(R.id.btn_login)
        btn_signup = findViewById<Button>(R.id.btn_signup)

        btn_login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)}

        btn_signup.setOnClickListener{
            val intent = Intent(this, SignUpRoleActivity::class.java)
            startActivity(intent)
        }

    }
}
