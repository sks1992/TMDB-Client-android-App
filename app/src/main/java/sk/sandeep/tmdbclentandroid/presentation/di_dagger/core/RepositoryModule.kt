package sk.sandeep.tmdbclentandroid.presentation.di_dagger.core

import dagger.Module
import dagger.Provides
import sk.sandeep.tmdbclentandroid.data.repository.artists.ArtistsRepositoryImpl
import sk.sandeep.tmdbclentandroid.data.repository.artists.data_source.ArtistsCachedDataSource
import sk.sandeep.tmdbclentandroid.data.repository.artists.data_source.ArtistsLocalDataSource
import sk.sandeep.tmdbclentandroid.data.repository.artists.data_source.ArtistsRemoteDataSource
import sk.sandeep.tmdbclentandroid.data.repository.movie.MovieRepositoryImpl
import sk.sandeep.tmdbclentandroid.data.repository.movie.data_source.MovieCachedDataSource
import sk.sandeep.tmdbclentandroid.data.repository.movie.data_source.MovieLocalDataSource
import sk.sandeep.tmdbclentandroid.data.repository.movie.data_source.MovieRemoteDataSource
import sk.sandeep.tmdbclentandroid.data.repository.tvShows.TvShowsRepositoryImpl
import sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source.TvShowsCachedDataSource
import sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source.TvShowsLocalDataSource
import sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source.TvShowsRemoteDataSource
import sk.sandeep.tmdbclentandroid.domain.repository.ArtistsRepository
import sk.sandeep.tmdbclentandroid.domain.repository.MovieRepository
import sk.sandeep.tmdbclentandroid.domain.repository.TvShowsRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCachedDataSource: MovieCachedDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource, movieLocalDataSource, movieCachedDataSource
        )
    }

    @Provides
    @Singleton
    fun provideArtistsRepository(
        artistsRemoteDataSource: ArtistsRemoteDataSource,
        artistsLocalDataSource: ArtistsLocalDataSource,
        artistsCachedDataSource: ArtistsCachedDataSource
    ): ArtistsRepository {
        return ArtistsRepositoryImpl(
            artistsRemoteDataSource, artistsLocalDataSource, artistsCachedDataSource
        )
    }

    @Provides
    @Singleton
    fun provideTvShowsRepository(
        tvShowsRemoteDataSource: TvShowsRemoteDataSource,
        tvShowsLocalDataSource: TvShowsLocalDataSource,
        tvShowsCachedDataSource: TvShowsCachedDataSource
    ): TvShowsRepository {
        return TvShowsRepositoryImpl(
            tvShowsRemoteDataSource, tvShowsLocalDataSource, tvShowsCachedDataSource
        )
    }
}