package com.example.sajili3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        val loginBtn: Button = findViewById(R.id.loginButton)

        loginBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()}
    }
}