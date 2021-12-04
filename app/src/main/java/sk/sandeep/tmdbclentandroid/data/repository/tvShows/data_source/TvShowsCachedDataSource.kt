package sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source

import sk.sandeep.tmdbclentandroid.data.module.tvShow.TvShow

interface TvShowsCachedDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}