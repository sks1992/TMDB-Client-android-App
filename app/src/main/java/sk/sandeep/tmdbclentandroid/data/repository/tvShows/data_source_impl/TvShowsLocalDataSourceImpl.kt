package sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source_impl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sk.sandeep.tmdbclentandroid.data.db.dao.TvShowsDao
import sk.sandeep.tmdbclentandroid.data.module.tvShow.TvShow
import sk.sandeep.tmdbclentandroid.data.repository.tvShows.data_source.TvShowsLocalDataSource


class TvShowsLocalDataSourceImpl(
    private val tvShowsDao: TvShowsDao
) : TvShowsLocalDataSource {

    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowsDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.deleteAllTvShows()
        }
    }
}