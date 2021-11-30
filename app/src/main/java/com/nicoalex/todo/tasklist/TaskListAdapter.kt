package com.nicoalex.todo.tasklist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.nicoalex.todo.R

class TaskListAdapter (private val taskList: List<Task>): RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    var onClickDelete: (Task) -> Unit = {}
    var onModifyTask: (Task) -> Unit = {}

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle =itemView.findViewById<TextView>(R.id.task_title)
        fun bind(task: Task) {
            textViewTitle.text = "Titre : " + task.title + if (!task.description.isEmpty()) "\nDescription : " + task.description else ""

            itemView.findViewById<ImageButton>(R.id.taskDeleteButton).setOnClickListener {
                onClickDelete(task)
            }

            itemView.findViewById<ImageButton>(R.id.EditButton).setOnClickListener {
                onModifyTask(task)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(taskList[position])
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

}
