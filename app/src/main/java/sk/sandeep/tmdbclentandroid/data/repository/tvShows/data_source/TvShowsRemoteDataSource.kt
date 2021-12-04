package sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source

import retrofit2.Response
import sk.sandeep.tmdbclentandroid.data.module.tvShow.TvShowList

interface TvShowsRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}