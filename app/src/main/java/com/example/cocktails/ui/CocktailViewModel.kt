package com.example.cocktails.ui

import Drink
import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cocktails.data.AppRepository
import com.example.cocktails.data.local.getDatabase
import com.example.cocktails.data.remote.DrinkApi
import kotlinx.coroutines.launch

// Enumeration zur Verwaltung des Ladezustands der API-Aufrufe
enum class ApiStatus { LOADING, ERROR, DONE }

class CocktailViewModel(application: Application) : AndroidViewModel(application)  {

    // Instanz der lokalen Datenbank
    private val database = getDatabase(application)

    // Instanz des Repositorys, das die Datenbank- und API-Zugriffe behandelt
    private val repository = AppRepository(DrinkApi, database)

    // Livedata für den Ladezustand der API-Aufrufe
    private val _loading = MutableLiveData<ApiStatus>()
    val loading: LiveData<ApiStatus>
        get() = _loading

    // Livedata für die Drinks
    //val drinks = repository.drinkList


    //init {
    //    loadData()
    //}

    // Funktion zum Abrufen der Drinks
    private fun loadData() {
        viewModelScope.launch {
            _loading.value = ApiStatus.LOADING
            try {
                val drinks = repository.getDrinksFromAPI()
                repository.insertDrinksToDB(drinks)
                _loading.value = ApiStatus.DONE
            } catch (e: Exception) {
                Log.e(TAG, "Error loading Data $e")
            }
        }
    }













    //später vill
    //fun updateDrinks(drinkList: List<Drink>) {
    //    viewModelScope.launch {
    //        try {
    //            repository.updateDrinks(drinkList)
    //        } catch (e: Exception) {
    //            Log.e(TAG, "Error updating Data $e")
    //        }
    //    }
    //}
}