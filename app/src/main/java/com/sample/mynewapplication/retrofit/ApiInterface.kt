package com.sample.mynewapplication.retrofit

import com.google.gson.JsonArray
import com.sample.mynewapplication.model.ResultModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface ApiInterface {

    @Headers("Postman-Token: 849d4436-392a-4ea4-9f27-a932fa1318d8")
    @POST("/api/add?code=aKHx1nNzQpgy9WXzNOJnJR4a/KpX05PTepvQeCvoq7CbanG84Ng81A==")
    fun add(@Body data: JsonArray): Call<ResultModel>


}