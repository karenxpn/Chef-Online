package com.developer.store.recipes.models

import com.google.gson.annotations.SerializedName

data class DishModel (@SerializedName( "image" )var image: String? = null,
                      @SerializedName( "title" )var title: String? = null,
                      @SerializedName( "recipe" )var recipe: String? = null )