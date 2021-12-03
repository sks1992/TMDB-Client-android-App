package sk.sandeep.tmdbclentandroid.data.module.movie

import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>

)