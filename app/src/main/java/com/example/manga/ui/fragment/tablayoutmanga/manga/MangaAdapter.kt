package com.example.manga.ui.fragment.tablayoutmanga.manga

import android.content.Context
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.manga.data.model.MangaModel
import com.example.manga.databinding.ItemMangaBinding


class MangaAdapter(context: Context) : PagingDataAdapter<MangaModel, MangaAdapter.MangaViewHolder>() {

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        return MangaViewHolder()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        TODO("Not yet implemented")
    }

    class MangaViewHolder(private val binding: ItemMangaBinding) {

    }


}

        class MangaViewHolder() :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mangaModel: MangaModel) {
            Glide.with(binding.imageManga).load(mangaModel.image).into(binding.imageManga)
            binding.tvDescription.text = mangaModel.description
            binding.tvYear.text = mangaModel.issue_year.toString()
            itemView.setOnClickListener {
                onclick?.invoke(mangaModel)
            }
        }



}



//class MangaAdapter(context: Context) :
//    PagingDataAdapter<MangaModel, MangaAdapter.ViewHolder>() {
//
//    private val data = mutableListOf<MangaModel>()
//    var onclick: ((MangaModel) -> Unit)? = null
//
//
//    fun setData(page: MangaModelPage) {
//        data.addAll(page.results)
//        notifyDataSetChanged()
//    }
//
//
//    private object MangaModelItemCallback : DiffUtil.ItemCallback<MangaModel>() {
//        override fun areItemsTheSame(oldItem: MangaModel, newItem: MangaModel): Boolean {
//            return oldItem == newItem
//        }
//
//        override fun areContentsTheSame(oldItem: MangaModel, newItem: MangaModel): Boolean {
//            return oldItem.description == newItem.description && oldItem.image == newItem.image
//        }
//
//    }
//
//    inner class ViewHolder(private val binding: ItemMangaBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(mangaModel: MangaModel) {
//            Glide.with(binding.imageManga).load(mangaModel.image).into(binding.imageManga)
//            binding.tvDescription.text = mangaModel.description
//            binding.tvYear.text = mangaModel.issue_year.toString()
//            itemView.setOnClickListener {
//                onclick?.invoke(mangaModel)
//            }
//        }
//
//
//    }
//

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(
//            ItemMangaBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(data[position])
//    }
//
//
//    override fun getItemCount(): Int = data.size
//
//
//    }



