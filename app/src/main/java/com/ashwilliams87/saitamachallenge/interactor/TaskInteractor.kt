package com.ashwilliams87.saitamachallenge.interactor

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

import java.util.*

class TaskInteractor : Observable() {
    private val TAG = "Saitama_TaskInteractor"

    fun getTasks() {
        GlobalScope.launch {
            notifyObservers(loadFromApi());
        }

    }

    suspend fun loadFromApi(): Int {
        Log.d(TAG, "Kourutines")
        setChanged()
        return 123;
    }


}