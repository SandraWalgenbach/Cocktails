package com.example.cocktails.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cocktails.databinding.FragmentPlusBinding

class PlusFragment : Fragment() {

    private lateinit var binding: FragmentPlusBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPlusBinding.inflate(inflater)
        return binding.root
    }
}