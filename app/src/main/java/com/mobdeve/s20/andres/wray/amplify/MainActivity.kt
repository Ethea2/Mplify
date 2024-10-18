package com.mobdeve.s20.andres.wray.amplify

import android.content.Intent
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.text.TextPaint
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var mplifyTitle: TextView
    private lateinit var loginButton: Button
    private lateinit var registerText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mplifyTitle = findViewById(R.id.mplifyTitle)
        loginButton = findViewById(R.id.loginButton)
        registerText = findViewById(R.id.registerLink)

        //register logic
        registerText.setOnClickListener {
            startRegisterActivity()
        }

        //login logic
        loginButton.setOnClickListener {
            startHomeActivity()
        }

        //gradient logic
        val paint: TextPaint = mplifyTitle.paint
        val width = paint.measureText(mplifyTitle.text.toString())

        val textShader = LinearGradient(0f, 0f, width, mplifyTitle.textSize, intArrayOf(
            0xFF0FA3B1.toInt(),
            0xFFF7A072.toInt()
        ), null, Shader.TileMode.CLAMP)

        mplifyTitle.paint.shader = textShader


    }

    private fun startRegisterActivity() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun startHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

}