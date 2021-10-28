package com.example.itunesapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.itunesapp.databinding.FragmentSongDescriptionBinding
import com.example.itunesapp.viewModel.ItunesViewModel
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SongDescription : Fragment() {

    private var _binding:FragmentSongDescriptionBinding? = null
    private val binding get() = _binding!!
    @FlowPreview
    private val viewModel:ItunesViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSongDescriptionBinding.inflate(inflater,container,false)
        return binding.root
    }

    @FlowPreview
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataObserver()
    }

    @FlowPreview
    private fun dataObserver() {
        viewModel.searchSongDescription.observe(viewLifecycleOwner,{
            initializeValues(binding)
        })
    }

    @FlowPreview
    private fun initializeValues(binding: FragmentSongDescriptionBinding) = with(binding) {

        songName.text = viewModel.searchSongDescription.value?.get(0)?.trackName
        artistName.text = viewModel.searchSongDescription.value?.get(0)?.artistName

    }

}