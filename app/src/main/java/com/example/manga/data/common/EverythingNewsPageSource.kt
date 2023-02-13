package com.example.manga.data.common
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.widget.Toast
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.Glide
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
//override fun inflateViewBinding(inflater: LayoutInflater): ActivitySelectedVideoBinding {
//    return ActivitySelectedVideoBinding.inflate(inflater)
//}
//
//override fun initListener() {
//    binding.tvBack.setOnClickListener {
//        Intent(this, DetailedPlaylistActivity::class.java).apply {
//            startActivity(this)
//        }
//    }
//}
//
//override fun initViewModel() {
//    intent.getStringExtra("videoId")?.let { id ->
//        viewModel.getVideo(id).observe(this) {
//            when (it.status) {
//                Status.SUCCESS -> {
//                    binding.progressbar.isVisible = false
//                    binding.tvVideoTitle.text = it.data?.snippet?.title
//                    binding.tvVideoDescription.text = it.data?.snippet?.description
//                    Glide.with(binding.imVideoThumbnail)
//                        .load(it.data?.snippet?.thumbnails?.medium?.url)
//                        .into(binding.imVideoThumbnail)
//                }
//                Status.ERROR -> {
//                    binding.progressbar.isVisible = false
//                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
//                }
//                Status.LOADING ->
//                    binding.progressbar.isVisible = true
//            }
//        }
//    }