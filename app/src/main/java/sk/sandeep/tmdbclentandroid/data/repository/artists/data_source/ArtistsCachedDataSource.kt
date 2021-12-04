package sk.sandeep.tmdbclentandroid.data.repository.artists.data_source

import sk.sandeep.tmdbclentandroid.data.module.artist.Artist

interface ArtistsCachedDataSource {

    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}