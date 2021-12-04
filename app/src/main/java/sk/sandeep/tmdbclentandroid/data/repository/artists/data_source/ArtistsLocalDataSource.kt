package sk.sandeep.tmdbclentandroid.data.repository.artists.data_source

import sk.sandeep.tmdbclentandroid.data.module.artist.Artist

interface ArtistsLocalDataSource {
    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAll()
}