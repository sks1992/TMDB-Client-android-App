package sk.sandeep.tmdbclentandroid.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import sk.sandeep.tmdbclentandroid.data.db.dao.ArtistsDao
import sk.sandeep.tmdbclentandroid.data.db.dao.MovieDao
import sk.sandeep.tmdbclentandroid.data.db.dao.TvShowsDao
import sk.sandeep.tmdbclentandroid.data.module.artist.Artist
import sk.sandeep.tmdbclentandroid.data.module.movie.Movie
import sk.sandeep.tmdbclentandroid.data.module.tvShow.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun artistsDao(): ArtistsDao
    abstract fun tvShowsDao(): TvShowsDao
}