package com.mobdeve.s20.andres.wray.amplify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

abstract class BaseActivity: AppCompatActivity() {
    protected fun setupBottomNav() {
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.navbar)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.homeIcon -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.profileIcon -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}