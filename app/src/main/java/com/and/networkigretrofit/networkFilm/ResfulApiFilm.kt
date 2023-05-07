package com.and.networkigretrofit.networkFilm

import com.and.networkigretrofit.modelFilm.ResponseDataFilmItem
import retrofit2.Call
import retrofit2.http.GET

interface ResfulApiFilm {
    @GET("film")
    fun getAllNews(): Call<List<ResponseDataFilmItem>>
}