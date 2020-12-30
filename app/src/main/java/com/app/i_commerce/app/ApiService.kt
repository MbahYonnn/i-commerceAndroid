package com.app.i_commerce.app

import com.app.i_commerce.model.ResponModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Leon Truzqy Zainun on 30,December,2020
 */
interface ApiService {
    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("name") name :String,
        @Field("email") email :String,
        @Field("password") password :String
    ): Call<ResponModel>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email :String,
        @Field("password") password :String
    ): Call<ResponModel>

    @GET("produk")
    fun getProduk(): Call<ResponModel>
}
