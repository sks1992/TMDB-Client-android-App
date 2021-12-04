package sk.sandeep.tmdbclentandroid.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sk.sandeep.tmdbclentandroid.domain.use_case.GetMoviesUseCase
import sk.sandeep.tmdbclentandroid.domain.use_case.UpdateMovieUseCase

class MovieViewModelFactory(
    private val getMovieUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return MovieViewModel(getMovieUseCase, updateMovieUseCase) as T
    }

}