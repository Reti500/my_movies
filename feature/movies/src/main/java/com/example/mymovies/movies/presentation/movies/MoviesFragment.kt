package com.example.mymovies.movies.presentation.movies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymovies.movies.R
import com.example.mymovies.movies.databinding.FragmentMoviesBinding
import com.example.mymovies.movies.presentation.adapters.MoviesAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MoviesFragment : Fragment(R.layout.fragment_movies) {

    private lateinit var binding: FragmentMoviesBinding
    private val moviesViewModel: MoviesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMoviesBinding.bind(view)

        moviesViewModel.loadTopRatedMovies()
        moviesViewModel.loadNowPlayingMovies()
        topRatedMoviesObserver()
        nowPlayingMoviesObserver()
    }

    private fun topRatedMoviesObserver() =
        moviesViewModel.topRatedMovies.observe(viewLifecycleOwner) { movies ->
            binding.topRatedMoviesRV.adapter = MoviesAdapter(movies) { goToMovieDetail(it.id) }
            binding.topRatedMoviesRV.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

    private fun nowPlayingMoviesObserver() =
        moviesViewModel.nowPlayingMovies.observe(viewLifecycleOwner) { movies ->
            binding.nowPlayingMoviesRV.adapter = MoviesAdapter(movies) { goToMovieDetail(it.id) }
            binding.nowPlayingMoviesRV.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

    private fun goToMovieDetail(id: Int) {
        val action =
            MoviesFragmentDirections.actionMoviesFragmentToMovieDetailFragment(
                movieId = id.toString()
            )
        findNavController().navigate(action)
    }
}