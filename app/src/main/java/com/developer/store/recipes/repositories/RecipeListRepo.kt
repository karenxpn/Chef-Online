package com.developer.store.recipes.repositories

import android.content.Context
import com.developer.store.recipes.R
import com.developer.store.recipes.services.RecipeListService

class RecipeListRepo(private val context: Context ): RecipeListService {
    override fun getCategoryInfo(): Pair<List<Int>, List<String>> {
        return Pair(getImageList(), getCategoryName() )
    }

    override fun getImageList(): List<Int> {
        return listOf(
            R.drawable.desserts,
            R.drawable.cookies,
            R.drawable.salads,
            R.drawable.pasta,
            R.drawable.dishes,
            R.drawable.soups
        )
    }

    override fun getCategoryName(): List<String> {
        return context.resources.getStringArray(R.array.listOfDishes).toList()
    }
}