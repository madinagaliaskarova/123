package com.example.manga.ui.fragment.tablayoutenter.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.manga.R
import com.example.manga.data.common.Status
import com.example.manga.data.model.SignUpModel
import com.example.manga.data.model.SignUpResponse
import com.example.manga.data.repository.Repository
import com.example.manga.databinding.FragmentMangaBinding
import com.example.manga.databinding.FragmentSignUpBinding
import com.example.manga.ui.BaseFragment
import com.example.manga.ui.fragment.tablayoutmanga.manga.MangaAdapter
import com.example.manga.ui.fragment.tablayoutmanga.manga.MangaViewModel


class SignUpFragment() : Fragment(R.layout.fragment_sign_up) {

//    private val binding by viewBinding(FragmentSignUpBinding::bind)
//
//        override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_sign_up, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        initViewModel()
//        binding.btnEnter.setOnClickListener{
//            createUser()
//        }
//    }
//
//        val viewModel: MangaViewModel by lazy {
//        ViewModelProvider(requireActivity())[MangaViewModel::class.java]
//    }
//
//
//
//    private fun createUser() {
//        val user  = SignUpModel("", "", "", "")
//        viewModel.asd(user)
//    }
//
//    private fun initViewModel() {
//        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
//        viewModel.asd(SignUpModel("", "", "", "")).observe(requireActivity(), Observer <SignUpResponse?>{
//            if(it  == null) {
//                Toast.makeText(requireContext(), "Failed to create User", Toast.LENGTH_LONG).show()
//            } else {
//                //{"code":201,"meta":null,"data":{"id":2877,"name":"xxxxxaaaaabbbbb","email":"xxxxxaaaaabbbbb@gmail.com","gender":"male","status":"active"}}
//                Toast.makeText(requireContext(), "Successfully created User", Toast.LENGTH_LONG).show()
//            }
//
//        })
//    }
}

//class MangaFragment : BaseFragment() {
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_manga, container, false)
//    }
//
//    private val binding by viewBinding(FragmentMangaBinding::bind)
//
//    private val mangaAdapter = MangaAdapter()
//
//    val viewModel: MangaViewModel by lazy {
//        ViewModelProvider(requireActivity())[MangaViewModel::class.java]
//    }
//
//    override fun initView() = with(binding) {
//        recyclerView.adapter = mangaAdapter
//    }
//
//    override fun initViewModel() {
//        viewModel.listManga().observe(requireActivity()) {
//            when (it.status) {
//                Status.SUCCESS -> {
//                    it.data?.let { it1 -> mangaAdapter.setData(it1) }
//                }
//                Status.ERROR -> {
//                    Toast.makeText(requireActivity(), it.message, Toast.LENGTH_LONG).show()
//                }
//            }
//        }
//    }
//}
//
//
//
//
//
