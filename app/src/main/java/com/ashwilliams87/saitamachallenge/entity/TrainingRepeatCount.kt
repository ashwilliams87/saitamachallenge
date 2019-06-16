package com.ashwilliams87.saitamachallenge.entity

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "saitama_training_repeat_count",
    primaryKeys = ["training_id", "task_id"],
    foreignKeys = [
        ForeignKey(entity = Task::class, parentColumns = ["id"], childColumns = ["task_id"]),
        ForeignKey(entity = Training::class, parentColumns = ["id"], childColumns = ["training_id"])]
)
data class TrainingRepeatCount(
    private var task_id: Int,
    private var training_id: Int,
    private var repeat_count: Int = 0
) {
    fun setTask_id(value: Int) {
        task_id = value
    }

    fun getTask_id(): Int {
        return task_id
    }

    fun setTraining_id(value: Int) {
        training_id = value
    }

    fun getTraining_id(): Int {
        return training_id
    }

    fun setRepeat_count(value: Int) {
        repeat_count = value
    }

    fun getRepeat_count(): Int {
        return repeat_count
    }
}