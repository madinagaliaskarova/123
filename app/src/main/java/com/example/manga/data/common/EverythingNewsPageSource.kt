package com.example.manga.data.common
import android.annotation.SuppressLint
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.manga.data.model.MangaModel
import com.example.manga.data.remotedb.ApiService
import retrofit2.HttpException

class EverythingNewsPageSource(

    private val apiService: ApiService,
    private val query: String
) : PagingSource<Int, MangaModel>() {

    override fun getRefreshKey(state: PagingState<Int, MangaModel>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: null
        return page?.prevKey?.plus(1) ?: page?.nextKey?.minus(1)
    }

    @SuppressLint("SuspiciousIndentation")
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MangaModel> {
        if(query.isEmpty()) {
            return LoadResult.Page(emptyList(), prevKey = null, nextKey = null)
        }

        val page: Int = params.key ?: 1
        val pageSize: Int = params.loadSize.coerceAtMost(20)

        val response = apiService.listManga(pageSize, page * pageSize)
        if(response.isSuccessful) {
           val result = checkNotNull(response.body()).results
            val nextKey = if (result.size < pageSize) null else page + 1
            val prevKey = if(page == 1) null else page -1
                return LoadResult.Page(result,prevKey, nextKey)
        }else {
            return LoadResult.Error(HttpException(response))
           }
    }
}


//class EverythingNewsPageSource(
//    private val apiService: ApiService,
//    private val query: String
//) : PagingSource<Int, MangaModel>() {
//
//    override fun getRefreshKey(state: PagingState<Int, MangaModel>): Int? {
//        val anchorPosition = state.anchorPosition ?: return null
//        val page = state.closestPageToPosition(anchorPosition)?: null
//        return page?.prevKey?.plus(1) ?: page?.nextKey?.minus(1)
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MangaModel> {
//        if (query.isEmpty()) {
//            return LoadResult.Page(emptyList(), prevKey = null, nextKey = null)
//        }
//
//        val page: Int = params.key ?: 1
//        val pageSize: Int = params.loadSize.coerceAtMost(NewsService.20)
//
//        val response = apiService.listManga(pageSize, page * pageSize)
//
//
//
////
////        val response = apiService.listManga(pageSize, page * pageSize)
////        if (response.isSuccesful) {
////
////            checkNotNull(response.body()).
////            val articles = checkNotNull(response.body()), MangaModel.map {it.toArticle}
////            val nextKey = if (articles.size < pageSize) null else page + 1
//            val prevKey =  if (page == 1 ) null else page -1
//
//            return LoadResult(articles, nextKey, prevKey)
//
//        } else {
//            return LoadResult.Error(HttpException(response))
//        }

//    override fun getRefreshKey(state: PagingState<Int, MangaModel>()): Int? {
//        val anchorPosition =  state.anchorPosition ?: return null
//        val page = state.closestPageToPosition(anchorPosition) ?: null
//        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
//
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Int> {
//        if(query.isEmpty()) {
//            return LoadResult.Page(emptyList(), prevKey = null, nextKey = null)
////        }
//
//        val page: Int = params.key ?: 1
//        val pageSize: Int = params.loadSize.coerceAtMost(NewsService.MAX_PAGE_SIZE)
//
//        val response = apiService.listManga(pageSize, page * pageSize)
//        if (response.isSuccesful) {
//
//            checkNotNull(response.body()).
//            val articles = checkNotNull(response.body()), MangaModel.map {it.toArticle}
//            val nextKey = if (articles.size < pageSize) null else page + 1
//            val prevKey =  if (page == 1 ) null else page -1
//
//            return LoadResult(articles, nextKey, prevKey)
//
//        } else {
//            return LoadResult.Error(HttpException(response))
//        }
