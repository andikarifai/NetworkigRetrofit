package com.and.networkigretrofit

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.and.networkigretrofit.databinding.ItemNewsBinding
import com.and.networkigretrofit.model.ResponseDataNewsItem
import com.bumptech.glide.Glide

class NewsAdapter(var listNews : List<ResponseDataNewsItem>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
    class ViewHolder(var binding: ItemNewsBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTitleNews.text = listNews[position].title
        holder.binding.tvAuthor.text = listNews[position].author
        holder.binding.tvDate.text = listNews[position].createdAt
        Glide.with(holder.itemView).load(listNews[position].image).into(holder.binding.ivNews)

        holder.binding.btnEdit.setOnClickListener{
            var edit = Intent(it.context, UpdateNewsActivity::class.java)
            edit.putExtra("update", listNews[position].id)
            it.context.startActivity(edit)
        }
    }

    override fun getItemCount(): Int {
        return listNews.size
    }

}