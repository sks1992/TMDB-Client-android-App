package sk.sandeep.tmdbclentandroid.presentation.tvShows

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import sk.sandeep.tmdbclentandroid.R
import sk.sandeep.tmdbclentandroid.databinding.ActivityTvShowsBinding

class TvShowsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvShowsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_shows)
        binding = DataBindingUtil
            .setContentView(this, R.layout.activity_tv_shows)
    }
}