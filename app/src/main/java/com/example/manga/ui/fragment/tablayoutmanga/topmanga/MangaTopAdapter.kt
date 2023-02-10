package com.example.manga.ui.fragment.tablayoutmanga.topmanga

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.manga.data.model.MangaModel
import com.example.manga.databinding.ItemMangaBinding

class MangaTopAdapter() : RecyclerView.Adapter<MangaTopAdapter.ViewHolder>() {
val onclick:((MangaModel)-> Unit)? = null
    private val data = mutableListOf<MangaModel>()


    fun setData(list: List<MangaModel>) {
        data.addAll(list)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMangaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }


    override fun getItemCount(): Int = data.size

    inner class ViewHolder(private val binding: ItemMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mangaModel: MangaModel) {

            Glide.with(binding.imageManga).load(mangaModel.image).into(binding.imageManga)
            binding.tvDescription.text = mangaModel.description
            binding.tvYear.text = mangaModel.issue_year.toString()

        }
    }
}

