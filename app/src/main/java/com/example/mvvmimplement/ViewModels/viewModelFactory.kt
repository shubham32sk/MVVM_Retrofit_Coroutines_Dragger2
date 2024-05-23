package com.example.mvvmimplement.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmimplement.repository.ProductRepository
import javax.inject.Inject

class viewModelFactory @Inject constructor(private val repository:ProductRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModel(repository) as T
    }
}