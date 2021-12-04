package sk.sandeep.tmdbclentandroid.presentation.di_dagger.core

import dagger.Module
import dagger.Provides
import sk.sandeep.tmdbclentandroid.domain.repository.ArtistsRepository
import sk.sandeep.tmdbclentandroid.domain.repository.MovieRepository
import sk.sandeep.tmdbclentandroid.domain.repository.TvShowsRepository
import sk.sandeep.tmdbclentandroid.domain.use_case.*

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(
        movieRepository: MovieRepository
    ): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(
        movieRepository: MovieRepository
    ):UpdateMovieUseCase{
        return UpdateMovieUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(
        tvShowRepository: TvShowsRepository
    ): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(
        tvShowRepository: TvShowsRepository
    ): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(
        artistRepository: ArtistsRepository
    ): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }
    @Provides
    fun provideUpdateArtistUseCase(
        artistRepository: ArtistsRepository
    ): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }

}