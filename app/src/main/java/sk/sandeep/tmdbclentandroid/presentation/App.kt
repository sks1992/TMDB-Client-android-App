package sk.sandeep.tmdbclentandroid.presentation

import android.app.Application
import sk.sandeep.tmdbclentandroid.BuildConfig
import sk.sandeep.tmdbclentandroid.presentation.di_dagger.Injector
import sk.sandeep.tmdbclentandroid.presentation.di_dagger.artists.ArtistSubComponent
import sk.sandeep.tmdbclentandroid.presentation.di_dagger.core.*
import sk.sandeep.tmdbclentandroid.presentation.di_dagger.movie.MovieSubComponent
import sk.sandeep.tmdbclentandroid.presentation.di_dagger.tvShows.TvShowSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataSourceModule(RemoteDataSourceModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}