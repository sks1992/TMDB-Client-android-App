package sk.sandeep.tmdbclentandroid.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import sk.sandeep.tmdbclentandroid.domain.use_case.GetMoviesUseCase
import sk.sandeep.tmdbclentandroid.domain.use_case.UpdateMovieUseCase

class MovieViewModel(
    private val getMovieUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMovieUseCase.execute()
        emit(movieList)
    }

    fun updateMoviesList() = liveData {
        val movieList = updateMovieUseCase.execute()
        emit(movieList)
    }
}