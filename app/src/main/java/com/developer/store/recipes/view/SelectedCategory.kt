package com.developer.store.recipes.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.developer.store.recipes.R
import com.developer.store.recipes.adapters.DishListAdapter
import com.developer.store.recipes.repositories.FirebaseRepository
import com.developer.store.recipes.viewmodels.DishVMFactory
import com.developer.store.recipes.viewmodels.DishViewModel
import com.developer.store.recipes.viewmodels.MainVMFactory
import com.developer.store.recipes.viewmodels.MainViewModel

class SelectedCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_category)

        ///get the intent passed from main activity ( title )
        val intentTitle = intent.getStringExtra("title")
        val dishList = findViewById<RecyclerView>(R.id.dishList)
        dishList.layoutManager = LinearLayoutManager( this )
        title = intentTitle


        val repo = FirebaseRepository( this )
        val viewModel: DishViewModel by lazy {
            ViewModelProviders.of(this,
                DishVMFactory(repo)
            ).get(DishViewModel::class.java)
        }

        viewModel.getData(intentTitle).subscribe {
            dishList.adapter = DishListAdapter( it )
        }
        ///get the list of dishes in current category



    }

    override fun onBackPressed() {
        super.onBackPressed()

        startActivity(Intent( this, MainActivity::class.java))
        finish()
    }
}
