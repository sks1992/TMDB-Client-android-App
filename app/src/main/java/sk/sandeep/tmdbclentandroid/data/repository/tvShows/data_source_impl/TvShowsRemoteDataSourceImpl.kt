package sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source_impl

import retrofit2.Response
import sk.sandeep.tmdbclentandroid.data.api.TMDBService
import sk.sandeep.tmdbclentandroid.data.module.tvShow.TvShowList
import sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source.TvShowsRemoteDataSource

class TvShowsRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowsRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}