package com.example.manga.ui.fragment.detailedmanga

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.manga.R
import com.example.manga.data.common.Status
import com.example.manga.databinding.FragmentDetailedManga2Binding
import com.example.manga.databinding.FragmentMangaBinding
import com.example.manga.ui.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator

class DetailedMangaFragment : BaseFragment<FragmentDetailedManga2Binding>() {



    override fun inflate(layoutInflater: LayoutInflater): FragmentDetailedManga2Binding {
        return FragmentDetailedManga2Binding.inflate(layoutInflater)
    }

    val viewModel: DetailedMangaViewModel by lazy {
        ViewModelProvider(requireActivity())[DetailedMangaViewModel::class.java]
    }

    override fun initViewModel() {
        super.initViewModel()

        val result = arguments?.getInt("key")
        if (result !== null) {

            viewModel.idManga(result).observe(requireActivity()) {
                when (it.status) {
                    Status.SUCCESS -> {

                        Glide.with(binding.mangaImg).load(it.data?.image).into(binding.mangaImg)
                        binding.tvYear.text = it.data?.created_at
                        binding.tvGenre.text = it.data?.genre?.map { it.toString() }.toString()
                        binding.tvType.text = it.data?.type
                        binding.tvDescription.text = it.data?.description
                    }

                    Status.ERROR -> {
                        Log.e("ololo", "onResponse " + it.message)

                    }
                }
            }
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





