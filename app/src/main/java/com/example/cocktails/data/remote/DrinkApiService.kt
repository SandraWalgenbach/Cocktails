package com.example.cocktails.data.remote

import com.example.cocktails.data.datamodels.DrinkList
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DrinkApiService {

    @GET("1/filter.php?a=Alcoholic")
    suspend fun getDrinkList(): DrinkList
}

object DrinkApi {
    val retrofitService: DrinkApiService by lazy { retrofit.create(DrinkApiService::class.java) }
}