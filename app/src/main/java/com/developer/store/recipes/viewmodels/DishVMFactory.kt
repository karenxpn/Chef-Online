package com.developer.store.recipes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.developer.store.recipes.services.FirebaseService

class DishVMFactory(private val service: FirebaseService) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(DishViewModel::class.java)) {
            return DishViewModel(service) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}