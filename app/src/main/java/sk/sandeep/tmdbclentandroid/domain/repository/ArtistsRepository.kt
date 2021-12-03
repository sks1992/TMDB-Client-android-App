package sk.sandeep.tmdbclentandroid.domain.repository

import sk.sandeep.tmdbclentandroid.data.module.artist.Artist

interface ArtistsRepository {

    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}