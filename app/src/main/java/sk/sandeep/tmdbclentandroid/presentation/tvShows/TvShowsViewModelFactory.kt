package sk.sandeep.tmdbclentandroid.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sk.sandeep.tmdbclentandroid.domain.use_case.GetTvShowsUseCase
import sk.sandeep.tmdbclentandroid.domain.use_case.UpdateTvShowsUseCase

class TvShowsViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return TvShowsViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
    }
}