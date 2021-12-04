package sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source_impl

import sk.sandeep.tmdbclentandroid.data.module.tvShow.TvShow
import sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source.TvShowsCachedDataSource

class TvShowsCachedDataSourceImpl : TvShowsCachedDataSource {
    private var tvShowsList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowsList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowsList.clear()
        tvShowsList = ArrayList(tvShows)
    }
}