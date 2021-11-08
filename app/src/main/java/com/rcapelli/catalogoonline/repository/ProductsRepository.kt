package com.rcapelli.catalogoonline.repository

import com.rcapelli.catalogoonline.api.MeLIApi
import com.rcapelli.catalogoonline.models.ProductsResponse

object ProductsRepository {
     fun getProductsFromApi(prod: String, listener: (ProductsResponse?) -> Unit) =
        MeLIApi.getProducts(prod,listener)

}