package com.developer.store.recipes.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.developer.store.recipes.R
import com.developer.store.recipes.adapters.RecipeListAdapter
import com.developer.store.recipes.callbacks.ClickCategory
import com.developer.store.recipes.repositories.RecipeListRepo
import com.developer.store.recipes.utils.DividerItemDecoration
import com.developer.store.recipes.viewmodels.MainVMFactory
import com.developer.store.recipes.viewmodels.MainViewModel
import com.facebook.appevents.AppEventsLogger
import com.squareup.okhttp.internal.Internal.logger

class MainActivity : AppCompatActivity(), ClickCategory {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ///initialization of views and viewmodel
        val recipeCategoryList = findViewById<RecyclerView>(R.id.recipeList)
        val divider = DividerItemDecoration( resources.getDrawable(R.drawable.divider))
        val repo = RecipeListRepo(this)
        val viewModel: MainViewModel by lazy {
            ViewModelProviders.of(this,
                MainVMFactory(repo)
            ).get(MainViewModel::class.java)
        }


        /// List all categories in recycler view
        recipeCategoryList.layoutManager = LinearLayoutManager( this )
        recipeCategoryList.addItemDecoration(divider)


        val adapter = RecipeListAdapter(viewModel.data.first, viewModel.data.second, this)
        recipeCategoryList.adapter = adapter

        logSentFriendRequestEvent()
    }

    /// callback of clicked category opening single one
    override fun categoryClicked(title: String) {
        val intent = Intent( this, SelectedCategory::class.java )
        intent.putExtra("title", title )
        startActivity(intent)
        finish()
    }

    /**
     * This function assumes logger is an instance of AppEventsLogger and has been
     * created using AppEventsLogger.newLogger() call.
     */
    fun logSentFriendRequestEvent() {
        AppEventsLogger.newLogger(this).logEvent("sentFriendRequest")
    }
}
