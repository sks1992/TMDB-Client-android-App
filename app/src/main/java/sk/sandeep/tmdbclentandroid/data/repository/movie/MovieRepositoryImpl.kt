package sk.sandeep.tmdbclentandroid.data.repository.movie

import android.util.Log
import sk.sandeep.tmdbclentandroid.data.module.movie.Movie
import sk.sandeep.tmdbclentandroid.data.module.movie.MovieList
import sk.sandeep.tmdbclentandroid.data.repository.movie.data_source.MovieCachedDataSource
import sk.sandeep.tmdbclentandroid.data.repository.movie.data_source.MovieLocalDataSource
import sk.sandeep.tmdbclentandroid.data.repository.movie.data_source.MovieRemoteDataSource
import sk.sandeep.tmdbclentandroid.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCachedDataSource: MovieCachedDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOFMovies: List<Movie> = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOFMovies)
        movieCachedDataSource.saveMoviesToCache(newListOFMovies)
        return newListOFMovies
    }

    suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDataSource.getMovie()
            val body: MovieList? = response.body()

            if (body != null) {
                movieList = body.movies
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCachedDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCachedDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}