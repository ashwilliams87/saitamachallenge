package com.ashwilliams87.saitamachallenge

import android.os.Bundle
import com.ashwilliams87.saitamachallenge.entity.Task
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ashwilliams87.saitamachallenge.adapter.TaskAdapter
import com.ashwilliams87.saitamachallenge.interactor.TaskInteractor
import com.ashwilliams87.saitamachallenge.presenter.MainPresenter
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

//    private val spinnerDay: Spinner = findViewById(R.id.date_day_spinner)
//    private val spinnerMonth: Spinner = findViewById(R.id.date_month_spinner)
//    private val spinnerYear: Spinner = findViewById(R.id.date_year_spinner)
//    private var adapterSpinnerDay = ArrayAdapter(this, android.R.layout.simple_spinner_item, ArrayList<Any>())
//    private var adapterSpinnerMonth = ArrayAdapter(this, android.R.layout.simple_spinner_item, ArrayList<Any>())
//    private var adapterSpinnerYear = ArrayAdapter(this, android.R.layout.simple_spinner_item, ArrayList<Any>())

    private var mainPresenter: MainPresenter? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val taskRecylerView: RecyclerView = findViewById(R.id.task_recycler_view)
        taskRecylerView.setLayoutManager(LinearLayoutManager(this))

        //pushUp
        //StandUp
        //Squats
        val fighterList = ArrayList<Task>()
        fighterList.add(Task(1, "PushUps"))
        fighterList.add(Task(2, "StandUps"))
        fighterList.add(Task(3, "Squats"))


        val adapter = TaskAdapter(fighterList)
        taskRecylerView.setAdapter(adapter)

        mainPresenter = MainPresenter(this, TaskInteractor());
        mainPresenter!!.loadTasks()
    }
}
