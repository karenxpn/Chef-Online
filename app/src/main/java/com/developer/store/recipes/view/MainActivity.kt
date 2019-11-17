package com.developer.store.recipes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.developer.store.recipes.R
import com.developer.store.recipes.adapters.RecipeListAdapter
import com.developer.store.recipes.repositories.RecipeListRepo
import com.developer.store.recipes.viewmodels.MainVMFactory
import com.developer.store.recipes.viewmodels.MainViewModel
import com.developer.store.utils.DividerItemDecoration

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recipeCategoryList = findViewById<RecyclerView>(R.id.recipeList)
        val divider = DividerItemDecoration( resources.getDrawable(R.drawable.divider))
        val repo = RecipeListRepo(this)
        val viewModel: MainViewModel by lazy {
            ViewModelProviders.of(this,
                MainVMFactory(repo)
            ).get(MainViewModel::class.java)
        }

        recipeCategoryList.layoutManager = LinearLayoutManager( this )
        recipeCategoryList.addItemDecoration(divider)


        val adapter = RecipeListAdapter( viewModel.data.first, viewModel.data.second )
        recipeCategoryList.adapter = adapter
    }
}
