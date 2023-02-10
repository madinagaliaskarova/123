package com.example.manga.ui.fragment.tablayoutmanga.topmanga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.manga.R
import com.example.manga.data.common.Status
import com.example.manga.databinding.FragmentMangaBinding
import com.example.manga.databinding.FragmentTopMangaBinding
import com.example.manga.ui.BaseFragment
import com.example.manga.ui.fragment.tablayoutmanga.manga.MangaAdapter
import com.example.manga.ui.fragment.tablayoutmanga.manga.MangaViewModel

class TopMangaFragment : BaseFragment<FragmentTopMangaBinding>() {


    override fun inflate(layoutInflater: LayoutInflater): FragmentTopMangaBinding {
        return FragmentTopMangaBinding.inflate(layoutInflater)
    }

    private val MangaAdapter = MangaAdapter()

//    val viewModel: MangaViewModel by viewModel()
    val viewModel: MangaTopViewModel by lazy {
    ViewModelProvider(requireActivity())[MangaTopViewModel::class.java]
}

    override fun initView() = with(binding) {
        recyclerView.adapter = MangaAdapter
    }
    override fun initViewModel() {
        viewModel.listManga().observe(requireActivity()) {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { it1 -> MangaAdapter.setData(it1) }
                }
                Status.ERROR -> {
                    Toast.makeText(requireActivity(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }


}

