package com.example.android.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.databinding.ItemMoviesBinding
import com.example.android.models.Results


class NewsListAdapter(
    private val list: MutableList<Results>,
    private val context: Context
) :
    RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {


    class NewsViewHolder(val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            ItemMoviesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = list[position]
        with(holder) {
// set up data in Item File from the api call
            Glide.with(context).load("https://image.tmdb.org/t/p/original"+article.posterPath).into(binding.movieImg)
            binding.movieTitle.text = article.title
            binding.movieRating.text = article.voteAverage.toString()
            binding.movieDesc.text = article.overview


    }
}

override fun getItemCount(): Int {
    return list.size

}}

