package sk.sandeep.tmdbclentandroid.presentation.tvShows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import sk.sandeep.tmdbclentandroid.R
import sk.sandeep.tmdbclentandroid.data.module.tvShow.TvShow
import sk.sandeep.tmdbclentandroid.databinding.ListItemBinding

class TvAdapter() : RecyclerView.Adapter<MyViewHolder>() {
    private val tvList = ArrayList<TvShow>()

    fun setList(tvShows: List<TvShow>) {
        tvList.clear()
        tvList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tvList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvList[position])
    }
}


class MyViewHolder(val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(tvShows: TvShow) {
        binding.titleTextView.text = tvShows.name
        binding.descriptionTextView.text = tvShows.overview
        val posterURL = "https://image.tmdb.org/t/p/w500" + tvShows.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

    }

}