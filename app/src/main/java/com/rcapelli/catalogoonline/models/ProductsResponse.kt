package com.rcapelli.catalogoonline.models

data class ProductsResponse (
    val site_id : String,
    val query : String,
    val results: List<SearchResult>)

data class SearchResult (
    val id: String,
    val site_id: String,
    val title: String,
    val price: Double,
    var thumbnail: String,
    val currency_id: String,
    val sold_quantity: Int,
    val condition: String,
    val accepts_mercadopago: Boolean,
    val address: LocationAdress
    )

data class LocationAdress(
    val state_name: String,
    val city_name: String)
