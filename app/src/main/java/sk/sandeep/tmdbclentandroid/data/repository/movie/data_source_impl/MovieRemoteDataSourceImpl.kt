package sk.sandeep.tmdbclentandroid.data.repository.movie.data_source_impl

import retrofit2.Response
import sk.sandeep.tmdbclentandroid.data.api.TMDBService
import sk.sandeep.tmdbclentandroid.data.module.movie.MovieList
import sk.sandeep.tmdbclentandroid.data.repository.movie.data_source.MovieRemoteDataSource

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
    ): MovieRemoteDataSource {
    override suspend fun getMovie(): Response<MovieList> {
return tmdbService.getPopularMovies(apiKey)
    }
}