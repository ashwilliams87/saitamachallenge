package com.ashwilliams87.saitamachallenge.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TaskResponse {
    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("task_name")
    @Expose
    var taskName: String = ""

}