package sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source

import sk.sandeep.tmdbclentandroid.data.module.tvShow.TvShow

interface TvShowsLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}