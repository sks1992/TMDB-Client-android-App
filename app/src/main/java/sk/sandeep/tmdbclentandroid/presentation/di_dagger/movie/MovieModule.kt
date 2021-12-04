package sk.sandeep.tmdbclentandroid.presentation.di_dagger.movie

import dagger.Module
import dagger.Provides
import sk.sandeep.tmdbclentandroid.domain.use_case.GetMoviesUseCase
import sk.sandeep.tmdbclentandroid.domain.use_case.UpdateMovieUseCase
import sk.sandeep.tmdbclentandroid.presentation.movie.MovieViewModelFactory

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMovieUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}