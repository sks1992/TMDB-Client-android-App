package sk.sandeep.tmdbclentandroid.presentation.di_dagger.core

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sk.sandeep.tmdbclentandroid.data.api.TMDBService
import javax.inject.Singleton

@Module
class NetModule(
    private val baseUrl: String
) {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Provides
    @Singleton
    fun provideDMDBService(
        retrofit: Retrofit
    ): TMDBService {
        return retrofit.create(TMDBService::class.java)
    }

}