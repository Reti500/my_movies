package com.example.mymovies.movies.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovies.entities.Movie
import com.example.mymovies.movies.databinding.ItemMovieBinding

class MoviesAdapter(
    private val onItemClick: (Movie) -> Unit
) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private val items = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ViewHolder =
        ViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MoviesAdapter.ViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    fun setItems(i: List<Movie>) {
        items.clear()
        items.addAll(0, i)
        notifyDataSetChanged()
    }

    inner class ViewHolder constructor(
        private val binding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movieModel: Movie) {
            binding.apply {
                movie = movieModel

                rootContainer.setOnClickListener { onItemClick(movieModel) }
            }

            binding.executePendingBindings()
        }
    }
}