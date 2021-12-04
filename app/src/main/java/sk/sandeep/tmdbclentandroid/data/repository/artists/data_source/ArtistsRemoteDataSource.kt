package sk.sandeep.tmdbclentandroid.data.repository.artists.data_source

import retrofit2.Response
import sk.sandeep.tmdbclentandroid.data.module.artist.ArtistList

interface ArtistsRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}