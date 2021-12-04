package sk.sandeep.tmdbclentandroid.presentation.di_dagger.artists

import dagger.Module
import dagger.Provides
import sk.sandeep.tmdbclentandroid.domain.use_case.GetArtistsUseCase
import sk.sandeep.tmdbclentandroid.domain.use_case.UpdateArtistsUseCase
import sk.sandeep.tmdbclentandroid.presentation.artists.ArtistsViewModelFactory

@Module
class ArtistsModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistsViewModelFactory {
        return ArtistsViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }
}