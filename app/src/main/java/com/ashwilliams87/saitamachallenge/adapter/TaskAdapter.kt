package com.ashwilliams87.saitamachallenge.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ashwilliams87.saitamachallenge.R
import com.ashwilliams87.saitamachallenge.entity.Task
import java.util.ArrayList

class TaskAdapter internal constructor(private val taskList: ArrayList<Task>) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onBindViewHolder(holder: TaskViewHolder, postition: Int) {
        val task = taskList[postition]
        holder.fighterName.setText(task.getTask_name())
    }

    private val mOnClickListener = MyOnClickListener()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.task_recyler_view, parent, false)
        itemView.setOnClickListener(mOnClickListener)
        return TaskViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // each data item is just a string in this case
        var fighterName: TextView = itemView.findViewById(R.id.task_name)

    }

    private inner class MyOnClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            Toast.makeText(view.context, "Get over here!", Toast.LENGTH_LONG).show()
        }
    }
}
