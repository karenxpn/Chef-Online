package com.developer.store.recipes.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.developer.store.recipes.R
import com.developer.store.recipes.models.DishModel

class SelectedDish : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_dish)

        val dish = intent.getSerializableExtra("dish") as DishModel
    }
}
