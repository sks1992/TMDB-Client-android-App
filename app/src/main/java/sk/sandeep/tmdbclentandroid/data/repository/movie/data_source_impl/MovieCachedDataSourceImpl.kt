package sk.sandeep.tmdbclentandroid.data.repository.movie.data_source_impl

import sk.sandeep.tmdbclentandroid.data.module.movie.Movie
import sk.sandeep.tmdbclentandroid.data.repository.movie.data_source.MovieCachedDataSource

class MovieCachedDataSourceImpl : MovieCachedDataSource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}