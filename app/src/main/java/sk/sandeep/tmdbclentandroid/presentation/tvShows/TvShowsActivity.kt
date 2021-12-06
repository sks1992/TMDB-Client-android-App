package sk.sandeep.tmdbclentandroid.presentation.tvShows

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
import sk.sandeep.tmdbclentandroid.databinding.ActivityTvShowsBinding
import sk.sandeep.tmdbclentandroid.presentation.di_dagger.Injector
import javax.inject.Inject

class TvShowsActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: TvShowsViewModelFactory
    private lateinit var tvShowViewModel: TvShowsViewModel
    private lateinit var adapter: TvAdapter

    private lateinit var binding: ActivityTvShowsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_shows)
        binding = DataBindingUtil
            .setContentView(this, R.layout.activity_tv_shows)

        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewModel = ViewModelProvider(this, factory)
            .get(TvShowsViewModel::class.java)

        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.tvRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvAdapter()
        binding.tvRecyclerView.adapter = adapter
        displayPopularTvShows()
    }

    private fun displayPopularTvShows() {
        binding.tvProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShows()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvProgressBar.visibility = View.GONE
            } else {
                binding.tvProgressBar.visibility = View.GONE
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
        binding.tvProgressBar.visibility = View.VISIBLE
        val response = tvShowViewModel.updateTvShowsList()

        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvProgressBar.visibility = View.GONE
            } else {
                binding.tvProgressBar.visibility = View.GONE
            }
        })
    }
}