package sk.sandeep.tmdbclentandroid.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import sk.sandeep.tmdbclentandroid.data.module.artist.ArtistList
import sk.sandeep.tmdbclentandroid.data.module.movie.MovieList
import sk.sandeep.tmdbclentandroid.data.module.tvShow.TvShowList

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apikey: String
    ): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query("api_key") apikey: String
    ): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(
        @Query("api_key") apikey: String
    ): Response<ArtistList >
}