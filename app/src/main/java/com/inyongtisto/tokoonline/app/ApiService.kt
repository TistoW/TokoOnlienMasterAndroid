package com.inyongtisto.tokoonline.app

import com.inyongtisto.tokoonline.model.Produk
import com.inyongtisto.tokoonline.model.ResponModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("register")
    fun register(
            @Field("name") name :String,
            @Field("email") email :String,
            @Field("phone") nomortlp :String,
            @Field("password") password :String
    ):Call<ResponModel>

    @FormUrlEncoded
    @POST("login")
    fun login(
            @Field("email") email :String,
            @Field("password") password :String
    ):Call<ResponModel>

    @GET("produk")
    fun getProduk():Call<ResponModel>
}