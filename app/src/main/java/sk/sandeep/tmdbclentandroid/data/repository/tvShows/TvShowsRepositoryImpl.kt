package sk.sandeep.tmdbclentandroid.data.repository.tvShows

import android.util.Log
import sk.sandeep.tmdbclentandroid.data.module.tvShow.TvShow
import sk.sandeep.tmdbclentandroid.data.module.tvShow.TvShowList
import sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source.TvShowsCachedDataSource
import sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source.TvShowsLocalDataSource
import sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source.TvShowsRemoteDataSource
import sk.sandeep.tmdbclentandroid.domain.repository.TvShowsRepository

class TvShowsRepositoryImpl(
    private val tvShowsRemoteDataSource: TvShowsRemoteDataSource,
    private val tvShowsLocalDataSource: TvShowsLocalDataSource,
    private val tvShowsCachedDataSource: TvShowsCachedDataSource
) : TvShowsRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOFTvShows: List<TvShow> = getTvShowsFromApi()
        tvShowsLocalDataSource.clearAll()
        tvShowsLocalDataSource.saveTvShowsToDB(newListOFTvShows)
        tvShowsCachedDataSource.saveTvShowsToCache(newListOFTvShows)
        return newListOFTvShows
    }

    suspend fun getTvShowsFromApi(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>

        try {
            val response = tvShowsRemoteDataSource.getTvShows()
            val body: TvShowList? = response.body()

            if (body != null) {
                tvShowsList = body.tvShows
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.toString())
        }
        return tvShowsList
    }


    suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>

        try {
            tvShowsList = tvShowsLocalDataSource.getTvShowsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.toString())
        }
        if (tvShowsList.isNotEmpty()) {
            return tvShowsList
        } else {
            tvShowsList = getTvShowsFromApi()
            tvShowsLocalDataSource.saveTvShowsToDB(tvShowsList)
        }
        return tvShowsList
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>
        try {
            tvShowsList = tvShowsCachedDataSource.getTvShowsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.toString())
        }
        if (tvShowsList.isNotEmpty()) {
            return tvShowsList
        } else {
            tvShowsList = getTvShowsFromDB()
            tvShowsCachedDataSource.saveTvShowsToCache(tvShowsList)
        }
        return tvShowsList
    }
}

/*



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
* */