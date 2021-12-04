package sk.sandeep.tmdbclentandroid.presentation.di_dagger.tvShows

import dagger.Subcomponent
import sk.sandeep.tmdbclentandroid.presentation.tvShows.TvShowsActivity

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowsActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }

}

