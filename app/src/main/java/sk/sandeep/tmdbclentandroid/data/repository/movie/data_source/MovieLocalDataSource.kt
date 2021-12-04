package sk.sandeep.tmdbclentandroid.data.repository.movie.data_source

import sk.sandeep.tmdbclentandroid.data.module.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}