package com.mobdeve.s20.andres.wray.amplify

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicRecyclerAdapter(private val songs: ArrayList<Music>, var mContext: Context): RecyclerView.Adapter<MusicRecyclerAdapter.MusicViewHolder>() {
    class MusicViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val artistImage: ImageView = itemView.findViewById(R.id.artistPhoto)
        val artistName: TextView = itemView.findViewById(R.id.artistTitle)
        val songTitle: TextView = itemView.findViewById(R.id.songTitle)
        val playButton: ImageButton = itemView.findViewById(R.id.playButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val musicInflater = LayoutInflater.from(parent.context).inflate(R.layout.song_layout, parent, false)
        return MusicViewHolder(musicInflater)
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val currentItem = songs[position]

        holder.songTitle.text = currentItem.title
        holder.artistName.text = currentItem.artist.name
        holder.artistImage.setImageResource(currentItem.artist.image)

        holder.playButton.setOnClickListener {
            openSongPage(currentItem)
        }
        holder.artistName.setOnClickListener {
            openArtistPage(currentItem.artist)
        }
        holder.artistImage.setOnClickListener {
            openArtistPage(currentItem.artist)
        }
    }

    private fun openArtistPage(artist: Artist) {
        mContext.startActivity(Intent(mContext, ArtistActivity::class.java).also {
            it.putExtra("artistName", artist.name)
            it.putExtra("artistImage", artist.image)
            it.putExtra("artistTag", artist.tag)
            it.putExtra("followers", artist.followers)
            it.putExtra("following", artist.following)
        })
    }

    private fun openSongPage(song: Music) {
        mContext.startActivity(Intent(mContext, MusicPlayerActivity::class.java).also {
            it.putExtra("artistName", song.artist.name)
            it.putExtra("songName", song.title)
            it.putExtra("artistImage", song.artist.image)
            it.putExtra("song", song.audio)
        })
    }
}