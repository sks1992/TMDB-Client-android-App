package sk.sandeep.tmdbclentandroid.presentation.di_dagger.core

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import sk.sandeep.tmdbclentandroid.data.db.TMDBDatabase
import sk.sandeep.tmdbclentandroid.data.db.dao.ArtistsDao
import sk.sandeep.tmdbclentandroid.data.db.dao.MovieDao
import sk.sandeep.tmdbclentandroid.data.db.dao.TvShowsDao
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideMovieDataBase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(
            context,
            TMDBDatabase::class.java,
            "tmdbclient"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Provides
    @Singleton
    fun provideArtistsDao(tmdbDatabase: TMDBDatabase): ArtistsDao {
        return tmdbDatabase.artistsDao()
    }

    @Provides
    @Singleton
    fun provideTvShowsDao(tmdbDatabase: TMDBDatabase): TvShowsDao {
        return tmdbDatabase.tvShowsDao()
    }
}