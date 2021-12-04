package sk.sandeep.tmdbclentandroid.presentation.di_dagger.core

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(
    private val context: Context
) {
    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}