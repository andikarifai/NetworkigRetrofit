package com.and.networkigretrofit.restApi

import com.and.networkigretrofit.model.ResponseAddDataNews
import com.and.networkigretrofit.model.DataNews
import com.and.networkigretrofit.model.ResponseDataNewsItem
import com.and.networkigretrofit.model.ResponseUpdateDataNews
import retrofit2.Call
import retrofit2.http.*

interface RestfulApi {
    @GET("news")
    fun getAllNews(): Call<List<ResponseDataNewsItem>>
    @POST("news")
    fun postDataNews(@Body request: DataNews) : Call<ResponseAddDataNews>
    @PUT("news/{id}")
    fun updateDataNews(
        @Path("id") id: Int,
        @Body request: DataNews,
        ) : Call<List<ResponseUpdateDataNews>>

}