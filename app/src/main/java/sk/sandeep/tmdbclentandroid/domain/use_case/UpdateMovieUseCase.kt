package sk.sandeep.tmdbclentandroid.domain.use_case

import sk.sandeep.tmdbclentandroid.data.module.movie.Movie
import sk.sandeep.tmdbclentandroid.domain.repository.MovieRepository

class UpdateMovieUseCase(
    private val movieRepository: MovieRepository
) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}