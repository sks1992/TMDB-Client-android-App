package sk.sandeep.tmdbclentandroid.domain.use_case

import sk.sandeep.tmdbclentandroid.data.module.tvShow.TvShow
import sk.sandeep.tmdbclentandroid.domain.repository.TvShowsRepository

class GetTvShowsUseCase(
    private val tvShowsRepository: TvShowsRepository
) {
    suspend fun execute(): List<TvShow>? = tvShowsRepository.getTvShows()
}