package com.developer.store.recipes.services

interface RecipeListService {
    fun getImageList(): List<Int>
    fun getCategoryName(): List<String>
    fun getCategoryInfo(): Pair<List<Int>, List<String>>
}