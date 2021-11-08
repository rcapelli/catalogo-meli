package com.rcapelli.catalogoonline.api


import com.rcapelli.catalogoonline.models.ProductsResponse
import com.rcapelli.catalogoonline.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.net.URLEncoder

object MeLIApi{
    val meliApiInterface: MLApiInterface by lazy { initApiClient() }

    private fun initApiClient(): MLApiInterface{
        val logging = HttpLoggingInterceptor()
        val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .client(OkHttpClient.Builder()
                .addInterceptor(logging)
                .build())
            .addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit.create(MLApiInterface::class.java)
    }

    interface MLApiInterface {
        @GET("sites/MLA/search")
        fun getProducts(@Query("q") prod: String): Call<ProductsResponse>
    }

    fun getProducts(prod: String, listener: (ProductsResponse?) -> Unit): Call<ProductsResponse>{
        val params = URLEncoder.encode(prod,"utf-8")
        val request = meliApiInterface.getProducts(params)
        request.enqueue(object: Callback<ProductsResponse> {
            override fun onResponse(call: Call<ProductsResponse>, response: Response<ProductsResponse>) {
                if(response.body() != null){
                    listener(response.body())
                }
            }
            override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
                if(request.isCanceled)
                    listener(null)
            }
        })
        return request
    }
}

