package com.example.sajili3

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Profile : AppCompatActivity() {    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_profile)

    setSupportActionBar(findViewById(R.id.toolbar))
    supportActionBar?.title = ""

    supportActionBar?.setDisplayHomeAsUpEnabled(true)

    val logoutBtn: TextView = findViewById(R.id.logoutTxt)
    val editDetailsBtn: TextView = findViewById(R.id.edtDetailsTxt)
    val moreDetailsTextV: TextView = findViewById(R.id.moreDetailsTxt)

    logoutBtn.setOnClickListener {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    editDetailsBtn.setOnClickListener{
        moreDetailsTextV.visibility = View.VISIBLE

        Handler().postDelayed(Runnable {
            moreDetailsTextV.visibility = View.GONE
        }, 1000)
    }
}

    override fun onNavigateUp(): Boolean {
        onSupportNavigateUp()
        return super.onNavigateUp()
    }
}