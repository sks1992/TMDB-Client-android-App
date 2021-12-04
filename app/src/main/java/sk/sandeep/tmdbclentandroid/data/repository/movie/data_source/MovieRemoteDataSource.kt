package sk.sandeep.tmdbclentandroid.data.repository.movie.data_source

import retrofit2.Response
import sk.sandeep.tmdbclentandroid.data.module.movie.MovieList

interface MovieRemoteDataSource {
    suspend fun getMovie(): Response<MovieList>
}