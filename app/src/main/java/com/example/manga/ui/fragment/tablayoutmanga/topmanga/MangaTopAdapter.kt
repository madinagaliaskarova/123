package com.example.manga.ui.fragment.tablayoutmanga.topmanga

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.manga.data.model.MangaModel
import com.example.manga.databinding.ItemMangaBinding
import com.example.manga.ui.fragment.tablayoutmanga.manga.MangaDiffCallback

class MangaTopAdapter(private val context: Context, private val onClick: ((MangaModel) -> Unit)?) : PagingDataAdapter<MangaModel, MangaTopAdapter.MangaViewHolder>(
    MangaDiffCallback()
) {

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMangaBinding.inflate(layoutInflater, parent, false)
        return MangaViewHolder(binding)
    }

    inner class MangaViewHolder(private val binding: ItemMangaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(manga: MangaModel?) {
            if (manga == null)
                return;
            manga.let {
                Glide.with(binding.imageManga).load(it.image).into(binding.imageManga)
                binding.tvDescription.text = it.description
                binding.tvYear.text = it.issue_year.toString()
                itemView.setOnClickListener {
                    onClick?.invoke(manga)
                }
            }
        }
    }
}

class MangaDiffCallback : DiffUtil.ItemCallback<MangaModel>() {
    override fun areItemsTheSame(oldItem: MangaModel, newItem: MangaModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MangaModel, newItem: MangaModel): Boolean {
        return oldItem == newItem
    }
}
