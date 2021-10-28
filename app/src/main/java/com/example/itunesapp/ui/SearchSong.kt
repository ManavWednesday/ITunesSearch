package com.example.itunesapp.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.itunesapp.R
import com.example.itunesapp.adapter.OnClick
import com.example.itunesapp.adapter.SearchAdapter
import com.example.itunesapp.databinding.FragmentSearchSongBinding
import com.example.itunesapp.viewModel.ItunesViewModel
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class SearchSong : Fragment(),OnClick {
    private var _binding: FragmentSearchSongBinding? = null
    private val binding get() = _binding!!
    @FlowPreview
    private val viewModel: ItunesViewModel by sharedViewModel()
    private val searchAdapter = SearchAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSearchSongBinding.inflate(inflater,container,false)
        return binding.root
    }

    @FlowPreview
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textWatcher(binding)
        initializeAdapter(binding)
        liveDataObserver()

    }

    @FlowPreview
    private fun liveDataObserver() {
        viewModel.searchSongsList.observe(viewLifecycleOwner,{
            viewModel.searchSongsList.value?.let { it1 -> searchAdapter.updateList(it1) }
            searchAdapter.notifyDataSetChanged()
        })
    }

    private fun initializeAdapter(binding: FragmentSearchSongBinding) = with(binding) {
        recyclerView.adapter = searchAdapter
        recyclerView.layoutManager = GridLayoutManager(context,1)
    }

    @FlowPreview
    private fun textWatcher(binding: FragmentSearchSongBinding) = with(binding) {

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(name: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.search(name.toString())
            }
            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    @FlowPreview
    override fun songDescription(trackId: Int, kind: String) {
        viewModel.searchSongDescription(trackId,kind)
        findNavController().navigate(R.id.action_searchSong_to_songDescription)
    }
}