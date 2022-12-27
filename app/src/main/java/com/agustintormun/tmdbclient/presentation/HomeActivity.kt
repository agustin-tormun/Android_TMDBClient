package com.agustintormun.tmdbclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.agustintormun.tmdbclient.R
import com.agustintormun.tmdbclient.databinding.ActivityHomeBinding
import com.agustintormun.tmdbclient.presentation.artist.ArtistActivity
import com.agustintormun.tmdbclient.presentation.movie.MovieActivity
import com.agustintormun.tmdbclient.presentation.tvshow.TVShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.movieButton.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.artistsButton.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }

        binding.tvShowsButton.setOnClickListener {
            val intent = Intent(this, TVShowActivity::class.java)
            startActivity(intent)
        }

    }
}