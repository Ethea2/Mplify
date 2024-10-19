package com.mobdeve.s20.andres.wray.amplify

import android.graphics.LinearGradient
import android.graphics.Shader
import android.media.MediaPlayer
import android.os.Bundle
import android.text.TextPaint
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class HomeActivity : BaseActivity() {
    private var data = Generator.loadData()
    private lateinit var popularSongs: RecyclerView
    private lateinit var recentReleases: RecyclerView
    private lateinit var mplifyTitle: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupBottomNav()

        mplifyTitle = findViewById(R.id.mplifyTitle)
        popularSongs = findViewById(R.id.popularRecycler)
        recentReleases = findViewById(R.id.recentRecycler)

        //gradient logic
        val paint: TextPaint = mplifyTitle.paint
        val width = paint.measureText(mplifyTitle.text.toString())

        val textShader = LinearGradient(0f, 0f, width, mplifyTitle.textSize, intArrayOf(
            0xFF0FA3B1.toInt(),
            0xFFF7A072.toInt()
        ), null, Shader.TileMode.CLAMP)

        mplifyTitle.paint.shader = textShader

        // recycler logic
        // popular songs
        popularSongs.layoutManager = LinearLayoutManager(this)
        popularSongs.setHasFixedSize(true)
        popularSongs.adapter = MusicRecyclerAdapter(data, this)

        // recent songs
        recentReleases.layoutManager = LinearLayoutManager(this)
        recentReleases.setHasFixedSize(true)
        recentReleases.adapter = MusicRecyclerAdapter(data, this)

    }
}