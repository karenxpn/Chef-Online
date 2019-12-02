package com.developer.store.recipes.callbacks

import com.developer.store.recipes.models.DishModel

interface ClickDish {
    fun dishClicked( dishModel: DishModel )
}