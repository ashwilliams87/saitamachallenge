package com.ashwilliams87.saitamachallenge.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.TypeConverters
import com.ashwilliams87.saitamachallenge.entity.Training
import com.ashwilliams87.saitamachallenge.helper.Converters
import java.util.*

@Dao
@TypeConverters(Converters::class)
interface TrainingDao {
    @Query("SELECT * FROM saitama_training WHERE training_date BETWEEN :from AND :to")
    fun getAllTrainings(from: Date, to: Date): List<Training>
}