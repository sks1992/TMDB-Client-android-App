package sk.sandeep.tmdbclentandroid.presentation.di_dagger.core

import sk.sandeep.tmdbclentandroid.presentation.di_dagger.artists.ArtistSubComponent
import sk.sandeep.tmdbclentandroid.presentation.di_dagger.movie.MovieSubComponent
import sk.sandeep.tmdbclentandroid.presentation.di_dagger.tvShows.TvShowSubComponent
import javax.inject.Singleton
import dagger.Component

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DatabaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataSourceModule::class,
        LocalDataSourceModule::class,
        CacheDataSourceModule::class,
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory


}