package com.example.mvvmimplement.Retrofit

import com.example.mvvmimplement.Models.RecipeXItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {
    //model bannne ke bad interface me define karenge

//    jo jo bhi end point hit karne hai idhar par define honge

    @GET("products")
    suspend fun getDATA(): Response<List<RecipeXItem>>
    // suspend isss liye kiya hai koiki corroutines ka use karne vale hai ham
    // we want that retrofitt ka object ahme dragger proovide kare


}