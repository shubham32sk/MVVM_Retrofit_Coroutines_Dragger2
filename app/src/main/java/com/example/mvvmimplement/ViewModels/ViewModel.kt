package com.example.mvvmimplement.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmimplement.Models.RecipeXItem
import com.example.mvvmimplement.repository.ProductRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModel(val repository: ProductRepository):ViewModel() {

    val datalivedata : StateFlow<List<RecipeXItem>>
        get()= repository.prducts
    init {

        viewModelScope.launch {
            repository.getDATA()
        }
    }
}