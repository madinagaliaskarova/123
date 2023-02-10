package com.example.manga.ui.fragment.tablayoutmanga.manga

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.manga.R
import com.example.manga.data.common.Status
import com.example.manga.databinding.FragmentMangaBinding
import com.example.manga.databinding.FragmentTopMangaBinding
import com.example.manga.ui.BaseFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class MangaFragment : BaseFragment<FragmentMangaBinding>() {

    override fun inflate(layoutInflater: LayoutInflater): FragmentMangaBinding {
        return FragmentMangaBinding.inflate(layoutInflater)
    }

    private var mangaAdapter = MangaAdapter()

    private val viewModel:MangaViewModel by sharedViewModel()

    override fun initView() = with(binding) {
        recyclerView.adapter = mangaAdapter
    }

    override fun initViewModel() {

        lifecycleScope.launch {
            viewModel.listMangas.collectLatest(mangaAdapter::sub)
        }

        viewModel.listManga().observe(viewLifecycleOwner) {
            when (it.) {
                Status.SUCCESS -> {

                }
            }
            Status.ERROR -> {

        }
        }

        mangaAdapter.onclick = {
            val bundle = Bundle()
            bundle.putInt("key", it.id)
            findNavController().navigate(R.id.detailedMangaFragment, bundle)

        }
    }
}