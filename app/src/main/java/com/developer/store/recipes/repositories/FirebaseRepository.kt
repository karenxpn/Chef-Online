package com.developer.store.recipes.repositories

import android.content.Context
import com.developer.store.recipes.models.DishModel
import com.developer.store.recipes.services.FirebaseService
import com.google.firebase.firestore.FirebaseFirestore
import io.reactivex.Observable

class FirebaseRepository( val context: Context ): FirebaseService {

    private val ref = FirebaseFirestore.getInstance()

    ///get data from firebase
    ///pass category title to get the data by category
    override fun getData(category: String): Observable<ArrayList<DishModel>> {
        val query: com.google.firebase.firestore.Query = ref.collection(category)
        val dishArray = ArrayList<DishModel>()

        return Observable.create {
            query.get().addOnCompleteListener { task ->
                if ( task.isSuccessful ) {
                    for ( snapshot in task.result!! ) {
                        val cur = snapshot.toObject(DishModel::class.java)
                        dishArray.add ( cur )
                    }
                    it.onNext(dishArray)
                }

            }
        }
    }
}