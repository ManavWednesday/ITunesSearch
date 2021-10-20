package com.example.itunesapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.itunesapp.R
import com.example.itunesapp.databinding.FragmentSongDescriptionBinding
import com.example.itunesapp.viewModel.ItunesViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class SongDescription : Fragment() {

    private var _binding:FragmentSongDescriptionBinding? = null
    private val binding get() = _binding!!
    private val viewModel:ItunesViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSongDescriptionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeValues(binding)

    }

    private fun initializeValues(binding: FragmentSongDescriptionBinding) = with(binding) {

        songName.text = viewModel.mRemoteDataModel.collectionName
        songDescription.text = viewModel.mRemoteDataModel.artistName

    }

}