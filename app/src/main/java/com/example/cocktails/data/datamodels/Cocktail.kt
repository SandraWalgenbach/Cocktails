package com.example.cocktails.data.datamodels

data class Cocktail (

    val name: String,
    val pic: String,
    val ingredients: String,
    val directions: String,
    val liked: Boolean = false
)