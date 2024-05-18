package com.huawei.countryapp.service

import com.huawei.countryapp.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductAPI {
    //https://fakestoreapi.com/products
    @GET("products")
    fun getProducts(): Call<List<Product>>
}