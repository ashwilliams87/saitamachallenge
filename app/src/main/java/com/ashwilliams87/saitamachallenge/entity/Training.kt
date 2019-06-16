package com.ashwilliams87.saitamachallenge.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.ashwilliams87.saitamachallenge.helper.Converters
import java.util.*

@Entity(tableName = "saitama_training")
data class Training(
    @PrimaryKey(autoGenerate = true) private var id: Int,

    @TypeConverters(Converters::class)
    private var training_date: Date?
) {

    fun setId(value: Int) {
        id = value
    }

    fun getId(): Int {
        return id
    }

    fun setTraining_date(value: Date?) {
        training_date = value
    }

    fun getTraining_date(): Date? {
        return training_date
    }

}