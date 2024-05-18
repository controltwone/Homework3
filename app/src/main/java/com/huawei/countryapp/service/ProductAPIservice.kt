package com.huawei.countryapp.service

import com.huawei.countryapp.model.Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://fakestoreapi.com/products

class ProductAPIservice {

    private val BASE_URL = "https://fakestoreapi.com/"

    private val api = Retrofit.Builder().
    baseUrl(BASE_URL).
    addConverterFactory(GsonConverterFactory.create()).build()
        .create(ProductAPI::class.java)

    fun getData(): Call<List<Product>>{
        return api.getProducts()
    }
}