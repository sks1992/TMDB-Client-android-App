package sk.sandeep.tmdbclentandroid.presentation.di_dagger.movie

import dagger.Subcomponent
import sk.sandeep.tmdbclentandroid.presentation.movie.MovieActivity

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }

}

