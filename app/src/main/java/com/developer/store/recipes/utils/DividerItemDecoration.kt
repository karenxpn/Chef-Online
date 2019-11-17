package com.developer.store.recipes.utils


import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView


class DividerItemDecoration(private val mDivider: Drawable) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(@NonNull outRect: Rect, @NonNull view: View, @NonNull parent: RecyclerView, @NonNull state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        //We do not want to add any padding for the first child
        //Because we do not want to have any unwanted space above the
        //Recycler view
        if (parent.getChildAdapterPosition(view) == 0) {
            return
        }

        //For every child, add some padding on the top
        //Intrinsic height method returns the actual size of the image
        //If the image size is 500*345 and you set in the XML
        //That the image view height and width is 200*200.
        //The when you call getIntrinsicHeight you get 500 and not 200
        //But when you call getHeight, you'll get 200.
        outRect.top = mDivider.intrinsicHeight
    }

    /**
     * Called only once.
     * This method is used for deciding the bounds of the divider. Meaning
     * We decide where the divider is to be drawn and how.
     *
     * @param c
     * @param parent
     * @param state
     */
    override fun onDraw(@NonNull c: Canvas, @NonNull parent: RecyclerView, @NonNull state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        //Divider Left is the distance of the child view from the parent
        //And dividerRight is the distance from the parent's left to the
        //right and -32 because we want the divider to be drawn with a padding
        // of 32 on the right too.
        val dividerLeft = 40
        val dividerRight = parent.width - 40

        //this is done for top and bottom divider for every view
        //This is because it is different for each view
        for (i in 0 until parent.childCount) {
            //This is done so that at the bottom of the last child
            //We don't want a divider there.
            if (i != parent.childCount - 1) {
                val child = parent.getChildAt(i)

                val params = child.layoutParams as RecyclerView.LayoutParams

                //Calculating the distance of the divider to be drawn from top
                val dividerTop = child.bottom + params.bottomMargin
                val dividerBottom = dividerTop + mDivider.intrinsicHeight

                mDivider.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom)
                mDivider.draw(c)
            }

        }
    }
}