package sk.sandeep.tmdbclentandroid.data.repository.movie.data_source

import sk.sandeep.tmdbclentandroid.data.module.movie.Movie

interface MovieCachedDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}