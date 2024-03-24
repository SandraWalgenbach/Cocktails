package com.example.cocktails.ui

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktails.data.model.Profil
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.storage

class ProfilViewModel : ViewModel(){

    val auth = Firebase.auth
    val firestore = Firebase.firestore
    val storage = Firebase.storage

    private val _user: MutableLiveData<FirebaseUser?> = MutableLiveData()
    val user: LiveData<FirebaseUser?>
        get() = _user

    //profil Document enthält Profil
    lateinit var profileRef: DocumentReference

    init {
        setupUserEnv()
        if(auth.currentUser != null) {
            Log.d("userId", auth.currentUser!!.uid)
        }
    }

    //Richtet Variablen ein die eingerichtet werden können wenn eingeloggt
    fun setupUserEnv() {

        _user.value = auth.currentUser

        //null prüfung
        auth.currentUser?.let { firebaseUser ->

            profileRef = firestore.collection("user").document(firebaseUser.uid)
        }

    }

    fun regist(email: String, psw: String) {

        auth.createUserWithEmailAndPassword(email, psw).addOnCompleteListener {
            if (it.isSuccessful) {
                setupUserEnv()

                val newProfil = Profil()
                profileRef.set(newProfil)

            } else {
                //Fehler
            }
        }

    }

    fun login(email: String, psw: String) {

        auth.signInWithEmailAndPassword(email, psw).addOnCompleteListener {
            if (it.isSuccessful) {
                //eingeloggt
                setupUserEnv()
            } else {
                //Fehler
            }
        }
    }

    fun logout() {

        auth.signOut()
        setupUserEnv()

    }


    fun uploadProfilePicture(uri: Uri) {

        val imageRef = storage.reference.child("images/${auth.currentUser!!.uid}/profilePicture")
        imageRef.putFile(uri).addOnCompleteListener {
            if (it.isSuccessful) {
                imageRef.downloadUrl.addOnCompleteListener { finalImageUrl ->
                    profileRef.update("profilePicture", finalImageUrl.result.toString())
                }
            }
        }
    }

}