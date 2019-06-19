package com.ashwilliams87.saitamachallenge.interactor

import android.util.Log
import com.ashwilliams87.saitamachallenge.dao.TaskDao
import com.ashwilliams87.saitamachallenge.entity.Task
import com.ashwilliams87.saitamachallenge.exceptions.TasksLoadApiFailException
import com.ashwilliams87.saitamachallenge.responses.TaskResponse
import com.ashwilliams87.saitamachallenge.helper.Repository

import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import java.util.*
import kotlin.collections.ArrayList

class TaskInteractor : Observable() {
    private val TAG = "Saitama_TaskInteractor"


    val job = SupervisorJob()
    val scope = CoroutineScope(Dispatchers.Default + job)

    // may throw Exception
    suspend fun getTasks(): Deferred<String> = coroutineScope {
        // (1)
        async {
            return@async ("WHAT IS THAT?");
        }
    }

    fun loadData() = scope.launch {
        // (2)
        try {
            notifyObservers(loadFromApi())
            this@TaskInteractor.getTasks().await()
        } catch (e: Exception) {
            Log.d(TAG, "Exception OMFG!")
            throw e
        }
    }

    private fun loadFromApi() {
        val taskInteractor: TaskInteractor = this;
        Repository.api!!.getAllTasks("TASK").enqueue(
            object : Callback<List<TaskResponse>> {
                override fun onFailure(call: Call<List<TaskResponse>>, t: Throwable) {
                    throw t;
                }

                override fun onResponse(call: Call<List<TaskResponse>>, response: Response<List<TaskResponse>>) {
                    if (response.code() == 200) {
                        val tasks: List<TaskResponse> = response.body()
                            ?: throw TasksLoadApiFailException("Ошибка получения Taks из api, пустой список")

                        //положили в базу и обсервер уведомили, отправили ему массив тасков
                        taskInteractor.updateObservers(taskInteractor.saveTasks(tasks))
                    }

                    if (response.code() == 404) {
                        throw TasksLoadApiFailException("Не найдено ничего!")
                    }
                }
            }
        )
    }

    private fun saveTasks(taskResponse: List<TaskResponse>): List<Task> {
        // пусть так
        val taskEntities: ArrayList<Task> = ArrayList()

        //TODO Вопрос с getId
        for (task in taskResponse) {
            taskEntities.add(Task(task.id, task.taskName))
        }

        Repository.roomDb!!.taskDao().insertAll(taskEntities)
        return Repository.roomDb!!.taskDao().getAllTasks()

    }

    fun updateObservers(parcel: List<Task>) {
        Log.d(TAG, "Kourutines")
        setChanged()
        notifyObservers(parcel)
    }


}

