package com.ashwilliams87.saitamachallenge.helper

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ashwilliams87.saitamachallenge.dao.TaskDao
import com.ashwilliams87.saitamachallenge.dao.TrainingDao
import com.ashwilliams87.saitamachallenge.dao.TrainingRepeatCountDao
import com.ashwilliams87.saitamachallenge.entity.Task
import com.ashwilliams87.saitamachallenge.entity.Training
import com.ashwilliams87.saitamachallenge.entity.TrainingRepeatCount

@Database(entities = [Task::class, Training::class, TrainingRepeatCount::class], version = 1)
@TypeConverters(Converters::class)
abstract class SaitamaDataBase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun trainingDao(): TrainingDao
    abstract fun trainingRepeatCountDao(): TrainingRepeatCountDao

    companion object {
        private var INSTANCE: SaitamaDataBase? = null
        fun getDatabase(context: Context): SaitamaDataBase? {
            if (INSTANCE == null) {
                synchronized(SaitamaDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        SaitamaDataBase::class.java, "chapter.db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}