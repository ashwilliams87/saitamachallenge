package com.ashwilliams87.saitamachallenge.`interface`

import com.ashwilliams87.saitamachallenge.entity.Task
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/api/saitama/exersices")
    abstract fun getLatestRates(@Query("base") resourceName: String): Call<List<Task>>
}