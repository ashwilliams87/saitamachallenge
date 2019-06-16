package com.ashwilliams87.saitamachallenge.presenter

import android.content.Context
import android.os.Looper
import android.util.Log
import com.ashwilliams87.saitamachallenge.`interface`.MainContract
import com.ashwilliams87.saitamachallenge.interactor.TaskInteractor
import java.util.*

class MainPresenter(
    private val context: Context,
    private val taskInteractor: TaskInteractor
) : Observer {

    //MainPresenter.Presenter

    private val TAG = "Saitama_MainPresenter"

    fun loadTasks() {
        taskInteractor.addObserver(this)
        taskInteractor.getTasks();

    }

    override fun update(obeservable: Observable?, parcel: Any?) {
        Log.d(TAG, "Updated")
        Log.d(TAG, parcel.toString())

        if(Looper.myLooper() == Looper.getMainLooper()) {
            Log.d(TAG, "MAIN")
        } else {
            Log.d(TAG, "NOT_MAIN")
        }

    }

}