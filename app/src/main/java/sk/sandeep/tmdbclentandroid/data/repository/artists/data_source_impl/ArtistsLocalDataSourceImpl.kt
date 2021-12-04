package sk.sandeep.tmdbclentandroid.data.repository.artists.data_source_impl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sk.sandeep.tmdbclentandroid.data.db.dao.ArtistsDao
import sk.sandeep.tmdbclentandroid.data.module.artist.Artist
import sk.sandeep.tmdbclentandroid.data.repository.artists.data_source.ArtistsLocalDataSource

class ArtistsLocalDataSourceImpl(
    private val artistsDao: ArtistsDao
) : ArtistsLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistsDao.getArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistsDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        artistsDao.deleteAllArtists()
    }
}