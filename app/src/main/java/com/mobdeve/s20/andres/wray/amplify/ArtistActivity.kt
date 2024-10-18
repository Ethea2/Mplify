package com.mobdeve.s20.andres.wray.amplify

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ArtistActivity : AppCompatActivity() {
    private var data = Generator.loadData()
    private lateinit var artistImage: ImageView
    private lateinit var artistNameText: TextView
    private lateinit var artistTagText: TextView
    private lateinit var followerText: TextView
    private lateinit var followingText: TextView
    private lateinit var songsRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_artist)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        artistImage = findViewById(R.id.artistPhoto)
        artistNameText = findViewById(R.id.artistName)
        artistTagText = findViewById(R.id.artistTag)
        followerText = findViewById(R.id.followers)
        followingText = findViewById(R.id.following)
        songsRecycler = findViewById(R.id.songsRecycler)

        val artistName = intent.getStringExtra("artistName")
        val artistPhoto = intent.getIntExtra("artistImage", 0)
        val artistTag = intent.getStringExtra("artistTag")
        val followers = intent.getIntExtra("followers", 0)
        val following = intent.getIntExtra("following", 0)

        artistImage.setImageResource(artistPhoto)
        artistNameText.text = artistName
        artistTagText.text = artistTag
        followerText.text = followers.toString()
        followingText.text = following.toString()

        songsRecycler.layoutManager = LinearLayoutManager(this)
        songsRecycler.setHasFixedSize(true)
        songsRecycler.adapter = MusicRecyclerAdapter(data, this)
    }
}