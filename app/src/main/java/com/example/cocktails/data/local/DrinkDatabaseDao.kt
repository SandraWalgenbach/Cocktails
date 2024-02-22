package com.example.cocktails.data.local

import Drink
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface DrinkDatabaseDao {

    //@Insert(onConflict = OnConflictStrategy.ABORT)
    //suspend fun insertAll(drinks: List<Drink>)

    //@Query("SELECT * from drinks")
    //fun getAll(): List<Drink>

    //@Update
    //suspend fun updateDrinks(drinks: List<Drink>)

}