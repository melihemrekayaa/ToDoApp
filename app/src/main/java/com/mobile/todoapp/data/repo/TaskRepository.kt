package com.mobile.todoapp.data.repo

import com.mobile.todoapp.data.datasource.TaskDataSource
import com.mobile.todoapp.data.entity.Task

class TaskRepository(var tds: TaskDataSource) {

    suspend fun loadTasks() : List<Task> = tds.loadTasks()

    suspend fun search(searchWord: String) : List<Task> = tds.search(searchWord)

    suspend fun save(task_name:String) = tds.save(task_name)

    suspend fun update(task_id:Int,task_name: String) = tds.update(task_id,task_name)

    suspend fun delete(task_id: Int) = tds.delete(task_id)
}