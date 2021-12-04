package sk.sandeep.tmdbclentandroid.data.repository.artists.data_source_impl

import retrofit2.Response
import sk.sandeep.tmdbclentandroid.data.api.TMDBService
import sk.sandeep.tmdbclentandroid.data.module.artist.ArtistList
import sk.sandeep.tmdbclentandroid.data.repository.artists.data_source.ArtistsRemoteDataSource

class ArtistsRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistsRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}