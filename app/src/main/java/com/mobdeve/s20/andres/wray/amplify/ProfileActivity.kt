package com.mobdeve.s20.andres.wray.amplify

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class ProfileActivity : BaseActivity() {
    private var data = Generator.loadData()
    private lateinit var songsRecycler: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupBottomNav()

        songsRecycler = findViewById(R.id.songsRecycler)
        songsRecycler.layoutManager = LinearLayoutManager(this)
        songsRecycler.setHasFixedSize(true)
        songsRecycler.adapter = MusicRecyclerAdapter(data, this)


    }
}