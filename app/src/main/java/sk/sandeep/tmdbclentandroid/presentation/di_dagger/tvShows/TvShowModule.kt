package sk.sandeep.tmdbclentandroid.presentation.di_dagger.tvShows

import dagger.Module
import dagger.Provides
import sk.sandeep.tmdbclentandroid.domain.use_case.GetTvShowsUseCase
import sk.sandeep.tmdbclentandroid.domain.use_case.UpdateTvShowsUseCase
import sk.sandeep.tmdbclentandroid.presentation.tvShows.TvShowsViewModelFactory

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowsViewModelFactory {
        return TvShowsViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }

}