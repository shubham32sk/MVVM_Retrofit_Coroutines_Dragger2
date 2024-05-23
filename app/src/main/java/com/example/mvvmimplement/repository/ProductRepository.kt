package com.example.mvvmimplement.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmimplement.Models.RecipeXItem
import com.example.mvvmimplement.Retrofit.FakerAPI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ProductRepository @Inject constructor( private val fakerAPI: FakerAPI) {
    private val _products = MutableStateFlow<List<RecipeXItem>>(emptyList())
    //live data is read only bahar se isse koi chnage nhi kar skta hai

    val prducts : StateFlow<List<RecipeXItem>>
        get() = _products
    suspend fun getDATA(){
        val result = fakerAPI.getDATA()

        if (result.isSuccessful && result.body()!=null){
            _products.emit(result.body()!!)
        }
    }
}