package com.example.complex_fragment_switcher.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.complex_fragment_switcher.databinding.FragmentBBinding

class BFragment : Fragment() {
    private lateinit var binding: FragmentBBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBBinding.inflate(inflater, container, false)

        return binding.root
    }
}