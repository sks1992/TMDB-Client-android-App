package sk.sandeep.tmdbclentandroid.presentation.di_dagger.core

import dagger.Module
import dagger.Provides
import sk.sandeep.tmdbclentandroid.data.api.TMDBService
import sk.sandeep.tmdbclentandroid.data.repository.artists.data_source.ArtistsRemoteDataSource
import sk.sandeep.tmdbclentandroid.data.repository.artists.data_source_impl.ArtistsRemoteDataSourceImpl
import sk.sandeep.tmdbclentandroid.data.repository.movie.data_source.MovieRemoteDataSource
import sk.sandeep.tmdbclentandroid.data.repository.movie.data_source_impl.MovieRemoteDataSourceImpl
import sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source.TvShowsRemoteDataSource
import sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source_impl.TvShowsRemoteDataSourceImpl
import javax.inject.Singleton

@Module
class RemoteDataSourceModule(private val apiKey: String) {

    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(
        tmdbService: TMDBService
    ): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Provides
    @Singleton
    fun provideArtistsRemoteDataSource(
        tmdbService: TMDBService
    ): ArtistsRemoteDataSource {
        return ArtistsRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Provides
    @Singleton
    fun provideTvShowsRemoteDataSource(
        tmdbService: TMDBService
    ): TvShowsRemoteDataSource {
        return TvShowsRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

}