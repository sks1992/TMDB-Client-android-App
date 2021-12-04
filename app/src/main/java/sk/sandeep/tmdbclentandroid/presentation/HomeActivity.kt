package sk.sandeep.tmdbclentandroid.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import sk.sandeep.tmdbclentandroid.R
import sk.sandeep.tmdbclentandroid.databinding.ActivityHomeBinding
import sk.sandeep.tmdbclentandroid.presentation.artists.ArtistsActivity
import sk.sandeep.tmdbclentandroid.presentation.movie.MovieActivity
import sk.sandeep.tmdbclentandroid.presentation.tvShows.TvShowsActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_home
        )

        binding.movieButton.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.tvButton.setOnClickListener {
            val intent = Intent(this, TvShowsActivity::class.java)
            startActivity(intent)
        }

        binding.artistsButton.setOnClickListener {
            val intent = Intent(this, ArtistsActivity::class.java)
            startActivity(intent)
        }
    }
}