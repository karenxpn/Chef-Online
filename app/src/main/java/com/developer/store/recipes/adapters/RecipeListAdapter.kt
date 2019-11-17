package com.developer.store.recipes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.developer.store.recipes.R
import kotlinx.android.synthetic.main.single_recipe_category.view.*

class RecipeListAdapter(
    private val images: List<Int>,
    private val category: List<String>): RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>() {

    class RecipeViewHolder( val card: View ): RecyclerView.ViewHolder( card )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from( parent.context ).inflate(R.layout.single_recipe_category, parent, false)
        return RecipeViewHolder( view )
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: RecipeViewHolder, i: Int) {
        with ( holder ) {
            with ( card ) {
                categoryImage.setImageResource(images[i])
                categoryTitle.text = category[i]
            }
        }
    }

}