package com.ashwilliams87.saitamachallenge.dao

import androidx.room.Dao
import androidx.room.Query
import com.ashwilliams87.saitamachallenge.entity.TrainingRepeatCount
import java.util.*

@Dao
interface TrainingRepeatCountDao {
    @Query("SELECT * FROM saitama_training_repeat_count WHERE training_id =:training_id AND task_id=:task_id")
    fun getAllRepeatCount(training_id: Int, task_id: Int): List<TrainingRepeatCount>
}