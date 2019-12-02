package com.developer.store.recipes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.developer.store.recipes.R
import com.developer.store.recipes.callbacks.ClickDish
import com.developer.store.recipes.models.DishModel
import com.developer.store.recipes.utils.GlideApp
import kotlinx.android.synthetic.main.single_recipe_preview.view.*

class DishListAdapter(private val list: List<DishModel>,
                      private val clickDish: ClickDish): RecyclerView.Adapter<DishListAdapter.DishListViewHolder>() {

    class DishListViewHolder( val card: View ): RecyclerView.ViewHolder( card )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_recipe_preview, parent, false)
        return DishListViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: DishListViewHolder, i: Int) {
        with ( holder ) {
            with ( card ) {
                GlideApp.with(recipePreviewImage.context)
                    .load(list[i].image)
                    .into(recipePreviewImage)

                recipePreviewTitle.text = list[i].title
                recipePreviewText.text = list[i].recipe
            }
        }

        holder.card.setOnClickListener {
            clickDish.dishClicked(list[i] )
        }
    }
}