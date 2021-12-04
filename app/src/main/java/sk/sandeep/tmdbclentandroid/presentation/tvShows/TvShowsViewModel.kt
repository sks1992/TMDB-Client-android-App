package sk.sandeep.tmdbclentandroid.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import sk.sandeep.tmdbclentandroid.domain.use_case.GetTvShowsUseCase
import sk.sandeep.tmdbclentandroid.domain.use_case.UpdateTvShowsUseCase

class TvShowsViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        val tvShowsList = getTvShowsUseCase.execute()
        emit(tvShowsList)
    }

    fun updateTvShowsList() = liveData {
        val tvShowsList = updateTvShowsUseCase.execute()
        emit(tvShowsList)
    }
}