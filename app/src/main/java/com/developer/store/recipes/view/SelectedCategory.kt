package com.developer.store.recipes.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.developer.store.recipes.R

class SelectedCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_category)

        ///get the intent passed from main activity ( title )
        val intentTitle = intent.getStringExtra("title")
        title = intentTitle


        ///get the list of dishes in current category


    }

    override fun onBackPressed() {
        super.onBackPressed()

        startActivity(Intent( this, MainActivity::class.java))
        finish()
    }
}
