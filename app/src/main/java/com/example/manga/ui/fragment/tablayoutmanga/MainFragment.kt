package com.example.manga.ui.fragment.tablayoutmanga

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.manga.R
import com.example.manga.databinding.FragmentMainBinding
import com.example.manga.ui.fragment.tablayoutmanga.ViewPagerAdapter
import com.example.manga.ui.fragment.tablayoutmanga.manga.MangaViewModel
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class MainFragment : Fragment() {


    private val binding by viewBinding(FragmentMainBinding::bind)
    private val viewModel: MangaViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        lateinit var searchView: SearchView

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.searchManga(it) }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })


        return view
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ViewPagerAdapter(childFragmentManager,viewLifecycleOwner.lifecycle)


        binding.pager.adapter = adapter


        TabLayoutMediator(binding.tabLayout, binding.pager ) {tab, position ->
            when(position) {

                0->{tab.text = "Вся манга"
                }

                1->{
                    tab.text = "Топ Манга"
                }
            }

        }.attach()
    }

    }

