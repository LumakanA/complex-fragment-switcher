package com.example.complex_fragment_switcher.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.complex_fragment_switcher.databinding.FragmentButtonsBinding

class ButtonsFragment : Fragment() {
    private lateinit var binding: FragmentButtonsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentButtonsBinding.inflate(inflater, container, false)

        return binding.root
    }
}