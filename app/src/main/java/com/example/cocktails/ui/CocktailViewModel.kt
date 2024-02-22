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

enum class ApiStatus { LOADING, ERROR, DONE }

class CocktailViewModel(application: Application) : AndroidViewModel(application)  {
    private val database = getDatabase(application)
    private val repository = AppRepository(DrinkApi, database)

    private val _loading = MutableLiveData<ApiStatus>()
    val loading: LiveData<ApiStatus>
        get() = _loading

    val drinks = repository.drinkList

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _loading.value = ApiStatus.LOADING
            try {
                val drinks = repository.getDrinksFromAPI()
                repository.insertDrinksToDB(drinks)
                _loading.value = ApiStatus.DONE
            } catch (e: Exception) {
                Log.e(TAG, "Error loading Data $e")
                if (drinks.value.isNullOrEmpty()) {
                    _loading.value = ApiStatus.ERROR
                } else {
                    _loading.value = ApiStatus.DONE
                }
            }
        }
    }

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