package com.example.cocktails.ui.fragment

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.cocktails.databinding.FragmentProfilBinding
import com.example.cocktails.ui.ProfilViewModel

class ProfilFragment : Fragment() {

    val viewModel: ProfilViewModel by activityViewModels()
    private lateinit var binding: FragmentProfilBinding

    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            if (uri != null) {
                //uri verweis auf bild
                viewModel.uploadProfilePicture(uri)
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialisieren von Adapter für die RecyclerView
        //binding.RVprofil.adapter = ProfilAdapter(dataset)

        //viewModel.profileRef.addSnapshotListener { snapshot, error ->

            //val profil = snapshot?.toObject(Profil::class.java)!!

            //if (profil.profilPicture != "") {
            //    binding.IVprofilPic.load(profil.profilPicture)
            //}
        //}

        binding.IVprofilPic.setOnClickListener {
            getContent.launch("image/*")
        }
    }
}