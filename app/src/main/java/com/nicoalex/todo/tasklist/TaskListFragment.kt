package com.nicoalex.todo.tasklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicoalex.todo.R

class TaskListFragment : Fragment(){
    private val taskList = listOf("Task 1", "Task 2", "Task 3")



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val recyclerView  = view?.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.adapter = TaskListAdapter(taskList)
        val rootView = inflater.inflate(R.layout.fragment_task_list, container, false)
        return rootView
    }
}