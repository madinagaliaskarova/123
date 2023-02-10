package com.example.manga.ui.fragment.tablayoutenter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.manga.R
import com.example.manga.databinding.FragmentMainBinding
import com.example.manga.databinding.FragmentTabLayoutBinding
import com.example.manga.ui.fragment.tablayoutmanga.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class TabLayoutFragment : Fragment(R.layout.fragment_tab_layout) {

    private val binding by viewBinding(FragmentTabLayoutBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = EnterViewPagerAdapter(childFragmentManager,viewLifecycleOwner.lifecycle)


        binding.pager.adapter = adapter


        TabLayoutMediator(binding.tabLayout, binding.pager ) {tab, position ->
            when(position) {

                0->{tab.text = "Вход"
                }

                1->{
                    tab.text = "Регистрация"
                }
            }

        }.attach()
    }

    }
