package sk.sandeep.tmdbclentandroid.presentation.di_dagger.core

import dagger.Module
import dagger.Provides
import sk.sandeep.tmdbclentandroid.data.db.dao.ArtistsDao
import sk.sandeep.tmdbclentandroid.data.db.dao.MovieDao
import sk.sandeep.tmdbclentandroid.data.db.dao.TvShowsDao
import sk.sandeep.tmdbclentandroid.data.repository.artists.data_source.ArtistsLocalDataSource
import sk.sandeep.tmdbclentandroid.data.repository.artists.data_source_impl.ArtistsLocalDataSourceImpl
import sk.sandeep.tmdbclentandroid.data.repository.movie.data_source.MovieLocalDataSource
import sk.sandeep.tmdbclentandroid.data.repository.movie.data_source_impl.MovieLocalDataSourceImpl
import sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source.TvShowsLocalDataSource
import sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source_impl.TvShowsLocalDataSourceImpl
import javax.inject.Singleton

@Module
class LocalDataSourceModule {

    @Provides
    @Singleton
    fun provideMovieLocalDataSource(
        movieDao: MovieDao
    ): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(
            movieDao
        )
    }

    @Provides
    @Singleton
    fun provideArtistsLocalDataSource(
        artistsDao: ArtistsDao
    ): ArtistsLocalDataSource {
        return ArtistsLocalDataSourceImpl(
            artistsDao
        )
    }

    @Provides
    @Singleton
    fun provideTvShowsLocalDataSource(
        tvShowsDao: TvShowsDao
    ): TvShowsLocalDataSource {
        return TvShowsLocalDataSourceImpl(
            tvShowsDao
        )
    }

}