package com.huawei.countryapp.model

data class Product(
    val id: Int,
    val title: String,
    val price: String,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating
)

data class Rating(
    val rate: Double,
    val count: Int
)
