package com.developer.store.recipes.services

import com.developer.store.recipes.models.DishModel
import io.reactivex.Observable

interface FirebaseService {

    fun getData(category: String): Observable<ArrayList<DishModel>>
}