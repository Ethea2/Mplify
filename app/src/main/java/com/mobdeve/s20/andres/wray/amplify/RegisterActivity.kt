package com.mobdeve.s20.andres.wray.amplify

import android.content.Intent
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Shader
import android.os.Bundle
import android.text.TextPaint
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    private lateinit var mplifyTitle: TextView
    private lateinit var registerButton: Button
    private lateinit var signinLink: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //init vars
        mplifyTitle = findViewById(R.id.mplifyTitle)
        registerButton = findViewById(R.id.registerButton)
        signinLink = findViewById(R.id.signinLink)

        //logic for gradient text
        val paint: TextPaint = mplifyTitle.paint
        val width = paint.measureText(mplifyTitle.text.toString())

        val textShader = LinearGradient(0f,0f, width, mplifyTitle.textSize,
            intArrayOf(
                0xFF0FA3B1.toInt(),
                0xFFF7A072.toInt()
            ), null, Shader.TileMode.CLAMP
        )

        mplifyTitle.paint.shader = textShader

        //logic for back to login
        registerButton.setOnClickListener {
            startLoginActivity()
        }
        signinLink.setOnClickListener {
            startLoginActivity()
        }
    }

    private fun startLoginActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}