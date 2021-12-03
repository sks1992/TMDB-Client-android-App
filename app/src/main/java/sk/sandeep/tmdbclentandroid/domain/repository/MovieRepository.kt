package sk.sandeep.tmdbclentandroid.domain.repository

import sk.sandeep.tmdbclentandroid.data.module.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies():List<Movie>?
}