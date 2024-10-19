package com.mobdeve.s20.andres.wray.amplify

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MusicPlayerActivity : AppCompatActivity() {
    private lateinit var songImage: ImageView
    private lateinit var songTitle: TextView
    private lateinit var artistName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_music_player)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val artist = intent.getStringExtra("artistName")
        val songName = intent.getStringExtra("songName")
        val artistImage = intent.getIntExtra("artistImage", 0)
        val song = intent.getIntExtra("song", 0)

        songImage = findViewById(R.id.songPhoto)
        artistName = findViewById(R.id.artistTitle)
        songTitle = findViewById(R.id.songTitle)

        songImage.setImageResource(artistImage)
        artistName.text = artist
        songTitle.text = songName

    }
}