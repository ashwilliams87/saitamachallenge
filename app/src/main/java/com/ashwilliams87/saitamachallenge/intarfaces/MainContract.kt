package com.ashwilliams87.saitamachallenge.intarfaces

import com.ashwilliams87.saitamachallenge.entity.Task

interface MainContract {

    interface Presenter {

        fun loadTasks()

    }

    interface View {
        fun updateTasksRecyclerView(tasks: List<Task>)
    }
}
