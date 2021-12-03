package sk.sandeep.tmdbclentandroid.data.module.tvShow

import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>
)