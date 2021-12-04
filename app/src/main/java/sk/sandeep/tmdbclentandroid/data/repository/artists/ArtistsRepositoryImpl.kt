package sk.sandeep.tmdbclentandroid.data.repository.artists

import android.util.Log
import sk.sandeep.tmdbclentandroid.data.module.artist.Artist
import sk.sandeep.tmdbclentandroid.data.module.artist.ArtistList
import sk.sandeep.tmdbclentandroid.data.repository.artists.data_source.ArtistsCachedDataSource
import sk.sandeep.tmdbclentandroid.data.repository.artists.data_source.ArtistsLocalDataSource
import sk.sandeep.tmdbclentandroid.data.repository.artists.data_source.ArtistsRemoteDataSource
import sk.sandeep.tmdbclentandroid.domain.repository.ArtistsRepository

class ArtistsRepositoryImpl(
    private val artistsRemoteDataSource: ArtistsRemoteDataSource,
    private val artistsLocalDataSource: ArtistsLocalDataSource,
    private val artistsCachedDataSource: ArtistsCachedDataSource
) : ArtistsRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOFArtists: List<Artist> = getArtistsFromApi()
        artistsLocalDataSource.clearAll()
        artistsLocalDataSource.saveArtistsToDB(newListOFArtists)
        artistsCachedDataSource.saveArtistsToCache(newListOFArtists)
        return newListOFArtists
    }

    suspend fun getArtistsFromApi(): List<Artist> {
        lateinit var artistsList: List<Artist>

        try {
            val response = artistsRemoteDataSource.getArtists()
            val body: ArtistList? = response.body()

            if (body != null) {
                artistsList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.toString())
        }
        return artistsList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistsList: List<Artist>

        try {
            artistsList = artistsLocalDataSource.getArtistsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.toString())
        }
        if (artistsList.isNotEmpty()) {
            return artistsList
        } else {
            artistsList = getArtistsFromApi()
            artistsLocalDataSource.saveArtistsToDB(artistsList)
        }
        return artistsList
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistsList: List<Artist>
        try {
            artistsList = artistsCachedDataSource.getArtistsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.toString())
        }
        if (artistsList.isNotEmpty()) {
            return artistsList
        } else {
            artistsList = getArtistsFromDB()
            artistsCachedDataSource.saveArtistsToCache(artistsList)
        }
        return artistsList
    }
}