package com.example.manga.ui.fragment.tablayoutenter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.manga.ui.fragment.tablayoutenter.signin.SignInFragment
import com.example.manga.ui.fragment.tablayoutenter.signup.SignUpFragment

class EnterViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                SignInFragment()
            }
            1 -> {
                SignUpFragment()
            }
            else -> {
                Fragment()
            }
        }
    }

}

