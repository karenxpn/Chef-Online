package com.developer.store.recipes.viewmodels

import androidx.lifecycle.ViewModel
import com.developer.store.recipes.models.DishModel
import com.developer.store.recipes.services.FirebaseService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DishViewModel(private val service: FirebaseService): ViewModel() {


    fun getData( category: String ): Observable<ArrayList<DishModel>> {
        return service.getData(category)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}