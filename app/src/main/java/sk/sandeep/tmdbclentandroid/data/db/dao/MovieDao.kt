package sk.sandeep.tmdbclentandroid.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import sk.sandeep.tmdbclentandroid.data.module.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movies: List<Movie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovie()

    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies(): List<Movie>
}