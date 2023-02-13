package com.example.manga.ui.fragment.tablayoutmanga.topmanga

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.manga.R
import com.example.manga.databinding.FragmentTopMangaBinding
import com.example.manga.ui.BaseFragment
import com.example.manga.ui.fragment.tablayoutmanga.manga.MangaViewModel
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class TopMangaFragment : BaseFragment<FragmentTopMangaBinding>() {


    override fun inflate(layoutInflater: LayoutInflater): FragmentTopMangaBinding {
        return FragmentTopMangaBinding.inflate(layoutInflater)
    }

    private var mangaTopAdapter = MangaTopAdapter(requireContext(), onClick = {
        val bundle = Bundle()
        bundle.putInt("key", it.id)
        findNavController().navigate(R.id.detailedMangaFragment, bundle)
    });

    private val viewModel: MangaViewModel by sharedViewModel()

    override fun initView() = with(binding) {
        recyclerView.adapter = mangaTopAdapter
    }

    override fun initViewModel() {
        lifecycleScope.launch {
            viewModel.listMangas.collectLatest { pagingData ->
                mangaTopAdapter.submitData(lifecycle, pagingData)
            }
        }
    }
}







