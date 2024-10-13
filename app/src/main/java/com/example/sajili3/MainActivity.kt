package com.example.sajili3

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardProfile: CardView = findViewById(R.id.cardProfile)
        cardProfile.setOnClickListener{
            startActivity(Intent(this, Profile::class.java))

        }
        val cardRegistration: CardView = findViewById(R.id.cardRegistration)
        cardRegistration.setOnClickListener{
                startActivity(Intent(this, Registration::class.java))
        }


        // Set onClickListener to open RegistrationActivity when clicked

    }
}