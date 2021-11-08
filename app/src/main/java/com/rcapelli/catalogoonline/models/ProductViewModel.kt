package com.rcapelli.catalogoonline.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.rcapelli.catalogoonline.repository.ProductsRepository

class ProductViewModel : ViewModel() {

    private val _productSearch = MutableLiveData<String>()
    val productSearch : LiveData<String> = _productSearch

    private val _productsFound = MutableLiveData<ProductsResponse>()
    val productsFound: LiveData<ProductsResponse> = _productsFound

    private val _chosenProduct = MutableLiveData<SearchResult>()
    val chosenProduct: LiveData<SearchResult> = _chosenProduct

    fun setSearch(lookFor: String, listener: (ProductsResponse?) -> Unit){
        _productSearch.value = lookFor
        getProductsFromApi(lookFor,listener)
    }

    fun getProductName() = productSearch.value

    fun setProducts(products: ProductsResponse?) {
        _productsFound.value = products
    }

    fun getProducts() = productsFound.value

    fun getProductsFromApi(prod: String, listener: (ProductsResponse?) -> Unit){
        ProductsRepository.getProductsFromApi(prod){
            if (it != null && it.results.isNotEmpty()){
                this.setProducts(it)
                listener(it)
            }
            else{
                this.setProducts(null)
                listener(null)
            }
        }
    }

    fun setChosenProduct(product: SearchResult){
        _chosenProduct.value = product
    }

    fun getChosenProduct() = chosenProduct.value


}