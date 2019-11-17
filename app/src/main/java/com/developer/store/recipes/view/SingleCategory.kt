package com.developer.store.recipes.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.developer.store.recipes.R

class SingleCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_category)

        title = intent.getStringExtra("title")


    }

    override fun onBackPressed() {
        super.onBackPressed()

        startActivity(Intent( this, MainActivity::class.java))
    }
}
