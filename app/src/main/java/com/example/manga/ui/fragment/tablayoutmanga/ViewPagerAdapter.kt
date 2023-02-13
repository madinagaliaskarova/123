package com.example.manga.ui.fragment.tablayoutmanga

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.manga.ui.fragment.tablayoutmanga.manga.MangaFragment
import com.example.manga.ui.fragment.tablayoutmanga.topmanga.TopMangaFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                MangaFragment()
            }
            1 -> {
                TopMangaFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}

