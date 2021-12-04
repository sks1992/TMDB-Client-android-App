package sk.sandeep.tmdbclentandroid.data.repository.artists.data_source_impl

import sk.sandeep.tmdbclentandroid.data.module.artist.Artist
import sk.sandeep.tmdbclentandroid.data.repository.artists.data_source.ArtistsCachedDataSource

class ArtistsCachedDataSourceImpl : ArtistsCachedDataSource {

    private var artistsList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistsList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistsList.clear()
        artistsList = ArrayList(artists)
    }
}