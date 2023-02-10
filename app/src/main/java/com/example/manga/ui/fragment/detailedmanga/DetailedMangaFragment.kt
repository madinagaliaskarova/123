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

class DetailedMangaFragment : BaseFragment<FragmentDetailedManga2Binding>() {

    override fun inflate(layoutInflater: LayoutInflater): FragmentDetailedManga2Binding {
        return FragmentDetailedManga2Binding.inflate(layoutInflater)
    }


    val viewModel: DetailedMangaViewModel by lazy {
        ViewModelProvider(requireActivity())[DetailedMangaViewModel::class.java]
    }

    fun getid() {
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

                        Toast.makeText(requireActivity(), it.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}

