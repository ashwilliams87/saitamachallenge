package com.ashwilliams87.saitamachallenge.intarfaces

import com.ashwilliams87.saitamachallenge.responses.TaskResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/api/saitama/tasks")
    fun getAllTasks(@Query("base") resourceName: String): Call<List<TaskResponse>>
}
