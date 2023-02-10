package com.example.manga.ui.fragment.firstscreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.manga.R
import com.example.manga.databinding.FragmentFirstScreenBinding
import com.example.manga.databinding.FragmentMainBinding

class FirstScreen() : Fragment(R.layout.fragment_first_screen) {

    private val binding by viewBinding(FragmentFirstScreenBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEnter.setOnClickListener{
            findNavController().navigate(R.id.action_firstScreen_to_tabLayoutFragment)
        }

        binding.btnSignUp.setOnClickListener{
            findNavController().navigate(R.id.action_firstScreen_to_tabLayoutFragment)
        }
    }
}