package com.ashwilliams87.saitamachallenge.dao

import androidx.room.Dao
import androidx.room.Query
import com.ashwilliams87.saitamachallenge.entity.Task
@Dao
interface TaskDao {
    @Query("SELECT * FROM saitama_task")
    fun getAllTasks(): List<Task>
}