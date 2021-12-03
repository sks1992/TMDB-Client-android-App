package sk.sandeep.tmdbclentandroid.domain.use_case

import sk.sandeep.tmdbclentandroid.data.module.artist.Artist
import sk.sandeep.tmdbclentandroid.domain.repository.ArtistsRepository

class GetArtistsUseCase(
    private val artistsRepository: ArtistsRepository
) {
    suspend fun execute(): List<Artist>? = artistsRepository.getArtists()
}