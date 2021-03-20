package com.yogadarma.stockbitapp.presentation.watchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yogadarma.core.data.Resource
import com.yogadarma.stockbitapp.databinding.FragmentWatchlistBinding
import com.yogadarma.stockbitapp.utils.toast
import org.koin.android.viewmodel.ext.android.viewModel

class WatchlistFragment : Fragment() {

    private var _binding: FragmentWatchlistBinding? = null
    private val binding get() = _binding!!

    private val watchlistViewModel: WatchlistViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWatchlistBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val watchlistAdapter = WatchlistAdapter()

        watchlistViewModel.getAllCrypto(50, "USD").observe(viewLifecycleOwner, { response ->
            when (response) {
                is Resource.Loading -> showShimmer()
                is Resource.Success -> {
                    dismissShimmer()
                    watchlistAdapter.setData(response.data)
                }
                is Resource.Error -> {
                    dismissShimmer()
                    context?.toast(response.message.toString())
                }
            }
        })

        with(binding.rvCrypto) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
            adapter = watchlistAdapter
        }
    }

    private fun showShimmer() {
        binding.svShimmer.visibility = View.VISIBLE
    }

    private fun dismissShimmer() {
        binding.svShimmer.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}