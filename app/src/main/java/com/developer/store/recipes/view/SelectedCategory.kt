package com.developer.store.recipes.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.developer.store.recipes.R
import com.developer.store.recipes.adapters.DishListAdapter
import com.developer.store.recipes.repositories.FirebaseRepository
import com.developer.store.recipes.utils.DividerItemDecoration
import com.developer.store.recipes.viewmodels.DishVMFactory
import com.developer.store.recipes.viewmodels.DishViewModel

class SelectedCategory : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_category)

        ///get the intent passed from main activity ( title )
        val intentTitle = intent.getStringExtra("title")
        title = intentTitle

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val divider = DividerItemDecoration( resources.getDrawable(R.drawable.divider))
        val dishList = findViewById<RecyclerView>(R.id.dishList)
        dishList.addItemDecoration(divider)
        dishList.layoutManager = LinearLayoutManager( this )

        ///get the list of dishes in current category

        val repo = FirebaseRepository( this )
        val viewModel: DishViewModel by lazy {
            ViewModelProviders.of(this,
                DishVMFactory(repo)
            ).get(DishViewModel::class.java)
        }

        viewModel.getData(intentTitle).subscribe {
            ///loading animation until data is fetched
            progressBar.visibility = View.GONE
            dishList.adapter = DishListAdapter( it )
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        startActivity(Intent( this, MainActivity::class.java))
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        finish()
    }
}
