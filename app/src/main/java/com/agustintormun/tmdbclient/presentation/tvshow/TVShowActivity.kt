package com.agustintormun.tmdbclient.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.agustintormun.tmdbclient.R
import com.agustintormun.tmdbclient.databinding.ActivityTvshowBinding

class TVShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvshowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tvshow)
    }
}