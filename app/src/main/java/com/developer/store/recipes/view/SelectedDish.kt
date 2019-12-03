package com.developer.store.recipes.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.developer.store.recipes.R
import com.developer.store.recipes.models.DishModel
import com.developer.store.recipes.utils.GlideApp
import com.makeramen.roundedimageview.RoundedImageView

class SelectedDish : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_dish)

        val dish = intent.getSerializableExtra("dish") as DishModel
        title = dish.title

        val recipe = findViewById<TextView>(R.id.recipe)
        val recipeTitle = findViewById<TextView>(R.id.recipeTitle)
        val recipeImage = findViewById<RoundedImageView>(R.id.recipeImage)


        GlideApp.with(recipeImage.context).load(dish.image).into(recipeImage)
        recipe.text = dish.recipe!!.replace( "  ", "\n\n" )
        recipeTitle.text = dish.title

    }
}
