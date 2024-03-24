package com.example.cocktails.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cocktails.R
import com.example.cocktails.databinding.FragmentLoginBinding
import com.example.cocktails.databinding.FragmentRegistBinding
import com.example.cocktails.ui.ProfilViewModel

class RegistFragment : Fragment() {

    private val viewModel: ProfilViewModel by activityViewModels()
    private lateinit var binding: FragmentRegistBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //speichert die angegebenen daten
        binding.BTNregistRegist.setOnClickListener {
            viewModel.regist(
                binding.ETTregistEmail.text.toString(),
                binding.ETTpsw.text.toString()
            )

        }

        //navigiert den eigeloggten user zum homescreen
        viewModel.user.observe(viewLifecycleOwner){
            if(it != null){
                findNavController().navigate(R.id.homeFragment)
            }
        }

        //navigiert zu loginFragment durch klick auf login button
        binding.BTNlog.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
    }
}