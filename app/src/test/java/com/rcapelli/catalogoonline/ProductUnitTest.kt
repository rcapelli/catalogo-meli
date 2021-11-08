package com.rcapelli.catalogoonline

import com.rcapelli.catalogoonline.models.LocationAdress
import com.rcapelli.catalogoonline.models.ProductsResponse
import com.rcapelli.catalogoonline.models.SearchResult
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ProductUnitTest {

    //respuesta de la api nula
    @Test
    fun apiResponseNull(){
        val response : ProductsResponse? = null
        assertEquals(response, null)
    }

    //respuesta de la api cuando no encuentra productos
    @Test
    fun apiResponseEmpty(){
        val response = ProductsResponse("MLA","product", emptyList())
        var resultsIsEmpty = false
        if(response.results.isEmpty()){
            resultsIsEmpty = true
        }
        assertEquals(resultsIsEmpty, true)
    }

    //producto elegido acepta Mercado Pago?
    @Test
    fun prodAcceptMP(){
        val prod= SearchResult("","","",0.0,"","",
            0,"",true, LocationAdress("",""))
        var accept = false
        if(prod.accepts_mercadopago){
            accept = true
        }
        assertEquals(accept,true)
    }

    //el producto elegido es nuevo?
    @Test
    fun prodIsNew(){
        val prod= SearchResult("","","",0.0,"","",
            0,"new",true, LocationAdress("",""))
        var new = false
        if(prod.condition == "new"){
            new = true
        }
        assertEquals(new,true)
    }

    //el producto elegido NO es nuevo?
    @Test
    fun prodIsUsed(){
        val prod= SearchResult("","","",0.0,"","",
            0,"condition",true, LocationAdress("",""))
        var used = false
        if(prod.condition == "new"){
            used = true
        }
        assertEquals(used,false)
    }

    //url de imagen de producto sin https (picasso)
    @Test
    fun urlWithoutHttps(){
        val prod = SearchResult("","","",0.0,"http://www.mercadolibre.com.ar/","",
            0,"",true, LocationAdress("",""))
        val productUrl : String = prod.thumbnail
        var url = productUrl
        if(productUrl.contains("http://")){
            url = "https"+productUrl.substring(4)
            prod.thumbnail = url
        }
        assertEquals(url,"https://www.mercadolibre.com.ar/")
    }
}