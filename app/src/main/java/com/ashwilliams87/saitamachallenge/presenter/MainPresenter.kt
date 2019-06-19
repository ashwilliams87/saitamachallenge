package com.ashwilliams87.saitamachallenge.presenter

import android.content.Context
import android.os.Looper
import android.util.Log
import com.ashwilliams87.saitamachallenge.entity.Task
import com.ashwilliams87.saitamachallenge.intarfaces.MainContract

import com.ashwilliams87.saitamachallenge.interactor.TaskInteractor
import java.util.*

class MainPresenter(
    private val mainView: MainContract.View,
    private val taskInteractor: TaskInteractor
) : MainContract.Presenter, Observer {

    //MainPresenter.Presenter

    private val TAG = "Saitama_MainPresenter"

    override fun loadTasks() {
        taskInteractor.addObserver(this)
        taskInteractor.loadData();

    }

    override fun update(obeservable: Observable?, parcel: Any?) {
        Log.d(TAG, "Updated")

        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.d(TAG, "MAIN")
        } else {
            Log.d(TAG, "NOT_MAIN")
        }

        when {
            obeservable is TaskInteractor -> {
                @Suppress("UNCHECKED_CAST")
                mainView.updateTasksRecyclerView((parcel as List<Task>))

            }

        }


    }

}