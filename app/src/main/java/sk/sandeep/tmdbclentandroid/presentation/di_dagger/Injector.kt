package sk.sandeep.tmdbclentandroid.presentation.di_dagger

import sk.sandeep.tmdbclentandroid.presentation.di_dagger.artists.ArtistSubComponent
import sk.sandeep.tmdbclentandroid.presentation.di_dagger.movie.MovieSubComponent
import sk.sandeep.tmdbclentandroid.presentation.di_dagger.tvShows.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}