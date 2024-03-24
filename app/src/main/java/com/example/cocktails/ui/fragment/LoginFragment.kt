package com.example.cocktails.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.cocktails.R
import com.example.cocktails.databinding.FragmentLoginBinding
import com.example.cocktails.ui.ProfilViewModel

class LoginFragment : Fragment() {

    private val viewModel: ProfilViewModel by activityViewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.BTNlogin.setOnClickListener {
            viewModel.login(
                binding.ETTemail.text.toString(),
                binding.ETTpassword.text.toString()
            )
        }

        //navigiert zu registFragment durch klick auf Regestrieren button
        binding.BTNregist.setOnClickListener {
            findNavController().navigate(R.id.registFragment)
        }

        //navigiert den eigeloggten user zum homescreen
        viewModel.user.observe(viewLifecycleOwner){
            if(it != null){
                findNavController().navigate(R.id.homeFragment)
            }
        }
    }
}