package com.ashwilliams87.saitamachallenge.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saitama_task")
data class Task internal constructor(
    @PrimaryKey(autoGenerate = true) private var id: Int,
    @ColumnInfo(name = "task_name") private var task_name: String
) {

    fun setId(value: Int) {
        id = value
    }

    fun getId(): Int {
        return id
    }

    fun setTask_name(value: String) {
        task_name = value
    }

    fun getTask_name(): String {
        return task_name
    }


}


