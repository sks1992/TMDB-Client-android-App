package sk.sandeep.tmdbclentandroid.data.repository.movie.data_source_impl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sk.sandeep.tmdbclentandroid.data.db.dao.MovieDao
import sk.sandeep.tmdbclentandroid.data.module.movie.Movie
import sk.sandeep.tmdbclentandroid.data.repository.movie.data_source.MovieLocalDataSource

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovie(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovie()
        }
    }
}