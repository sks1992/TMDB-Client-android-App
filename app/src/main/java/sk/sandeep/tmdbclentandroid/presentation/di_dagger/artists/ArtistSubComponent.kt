package sk.sandeep.tmdbclentandroid.presentation.di_dagger.artists

import dagger.Subcomponent
import sk.sandeep.tmdbclentandroid.presentation.artists.ArtistsActivity

@ArtistScope
@Subcomponent(modules = [ArtistsModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistsActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }

}

