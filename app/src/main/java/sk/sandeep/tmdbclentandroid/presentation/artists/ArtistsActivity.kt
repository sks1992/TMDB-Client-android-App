package sk.sandeep.tmdbclentandroid.presentation.artists

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import sk.sandeep.tmdbclentandroid.R
import sk.sandeep.tmdbclentandroid.databinding.ActivityArtistsBinding
import sk.sandeep.tmdbclentandroid.presentation.di_dagger.Injector
import javax.inject.Inject

class ArtistsActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistsViewModelFactory
    private lateinit var artistViewModel: ArtistsViewModel
    private lateinit var adapter: ArtistAdapter
    private lateinit var binding: ActivityArtistsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artists)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artists)

        (application as Injector).createArtistSubComponent()
            .inject(this)

        artistViewModel = ViewModelProvider(this, factory)
            .get(ArtistsViewModel::class.java)
        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        displayPopularArtists()
    }

    private fun displayPopularArtists() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateTvShows() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val response = artistViewModel.updateArtistsList()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                binding.artistProgressBar.visibility = View.GONE
            }
        })
    }
}