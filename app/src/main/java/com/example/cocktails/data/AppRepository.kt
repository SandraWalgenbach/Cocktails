package com.example.cocktails.data

import Drink
import com.example.cocktails.data.local.DrinkDatabase
import com.example.cocktails.data.remote.DrinkApi

class AppRepository (private val api: DrinkApi, private val database: DrinkDatabase) {

    //val drinkList = database.drinkDatabaseDao.getAll()

    suspend fun getDrinksFromAPI(): List<Drink> {
        return api.retrofitService.getDrinkList().drinks
    }

    suspend fun insertDrinksToDB(drinks: List<Drink>) {
        //database.drinkDatabaseDao.insertAll(drinks)
    }

    //suspend fun updateDrinks(drinks: List<Drink>) {
    //    database.drinkDatabaseDao.updateDrinks(drinks)
    //}

}