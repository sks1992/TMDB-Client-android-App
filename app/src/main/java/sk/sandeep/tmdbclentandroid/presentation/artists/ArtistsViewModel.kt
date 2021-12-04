package sk.sandeep.tmdbclentandroid.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import sk.sandeep.tmdbclentandroid.domain.use_case.GetArtistsUseCase
import sk.sandeep.tmdbclentandroid.domain.use_case.UpdateArtistsUseCase

class ArtistsViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    fun getArtists() = liveData {
        val artistsList = getArtistsUseCase.execute()
        emit(artistsList)
    }

    fun updateArtistsList() = liveData {
        val artistsList = updateArtistsUseCase.execute()
        emit(artistsList)
    }
}