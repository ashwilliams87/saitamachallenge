package com.ashwilliams87.saitamachallenge.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ashwilliams87.saitamachallenge.entity.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM saitama_task")
    fun getAllTasks(): List<Task>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)

    @Insert
    @JvmSuppressWildcards
    fun insertAll(objects: List<Task>)
}