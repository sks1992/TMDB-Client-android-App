package sk.sandeep.tmdbclentandroid.presentation.di_dagger.core

import dagger.Module
import dagger.Provides
import sk.sandeep.tmdbclentandroid.data.repository.artists.data_source.ArtistsCachedDataSource
import sk.sandeep.tmdbclentandroid.data.repository.artists.data_source_impl.ArtistsCachedDataSourceImpl
import sk.sandeep.tmdbclentandroid.data.repository.movie.data_source.MovieCachedDataSource
import sk.sandeep.tmdbclentandroid.data.repository.movie.data_source_impl.MovieCachedDataSourceImpl
import sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source.TvShowsCachedDataSource
import sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source_impl.TvShowsCachedDataSourceImpl
import javax.inject.Singleton

@Module
class CacheDataSourceModule {

    @Provides
    @Singleton
    fun provideMovieCacheDataSource(): MovieCachedDataSource {
        return MovieCachedDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideArtistsCacheDataSource(): ArtistsCachedDataSource {
        return ArtistsCachedDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideTvShowsCacheDataSource(): TvShowsCachedDataSource {
        return TvShowsCachedDataSourceImpl()
    }

}