package sk.sandeep.tmdbclentandroid.domain.repository

import sk.sandeep.tmdbclentandroid.data.module.tvShow.TvShow

interface TvShowsRepository {

    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}