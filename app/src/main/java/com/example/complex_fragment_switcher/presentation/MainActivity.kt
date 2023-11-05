package com.example.complex_fragment_switcher.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.complex_fragment_switcher.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}