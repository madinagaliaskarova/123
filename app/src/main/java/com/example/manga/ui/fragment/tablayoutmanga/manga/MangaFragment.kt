package com.example.manga.ui.fragment.tablayoutmanga.manga

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.manga.R
import com.example.manga.databinding.FragmentMangaBinding
import com.example.manga.ui.BaseFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class MangaFragment : BaseFragment<FragmentMangaBinding>() {

//    private lateinit var mangaAdapter: MangaAdapter
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        mangaAdapter = MangaAdapter(requireContext(), onClick = {
//            // Handle onClick logic here
//        })
//        // other code here
//    }


    override fun inflate(layoutInflater: LayoutInflater): FragmentMangaBinding {
        return FragmentMangaBinding.inflate(layoutInflater)
    }

    private val viewModel: MangaViewModel by sharedViewModel()

    override fun initView() = with(binding) {
        recyclerView.adapter = mangaAdapter
    }

    override fun initViewModel() {
        lifecycleScope.launch {
            viewModel.listMangas.collectLatest { pagingData ->
                mangaAdapter.submitData(lifecycle, pagingData)
            }
        }
    }

    private var mangaAdapter = MangaAdapter(requireContext(), onClick = {
        val bundle = Bundle()
        bundle.putInt("key", it.id)
        findNavController().navigate(R.id.detailedMangaFragment, bundle)

    });
}


//
//    private val mangaAdapter = MangaAdapter(requireContext(), onClick = { manga ->
//        // Handle onClick event here
//    })
//
//    private val viewModel: MangaViewModel by sharedViewModel()
//
//    override fun initView() = with(binding) {
//        recyclerView.adapter = mangaAdapter
//    }
//
//    override fun initViewModel() {
//
//        lifecycleScope.launch {
//            viewModel.listMangas.collectLatest(mangaAdapter::submitList)
//        }
//
//        viewModel.listManga().observe(viewLifecycleOwner, Observer {
//            when (it.status) {
//                Status.SUCCESS -> {
//
//                }
//                Status.ERROR -> {
//
//                }
//            }
//        })
//        mangaAdapter.onclick = {
//            val bundle = Bundle()
//            bundle.putInt("key", it.id)
//            findNavController().navigate(R.id.detailedMangaFragment, bundle)
//
//        }
//    }


//}
//    override fun initViewModel() {
//
//        lifecycleScope.launch {
//            viewModel.listMangas.collectLatest(mangaAdapter::sub)
//        }
//
//        viewModel.listManga().observe(viewLifecycleOwner) {
//            when (it.status) {
//                Status.SUCCESS -> {
//                    it.data?.let { it1 -> MangaAdapter.setData(it1) }
//                }
//            }
//            Status.ERROR -> {
//            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
//
//        }
//        }
