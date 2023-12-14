package com.mobile.todoapp.data.datasource

import androidx.navigation.Navigation
import com.mobile.todoapp.data.entity.Task
import com.mobile.todoapp.databinding.FragmentAddBinding
import com.mobile.todoapp.room.TaskDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskDataSource(var tdao: TaskDao) {

    suspend fun loadTasks() : List<Task> =
        withContext(Dispatchers.IO){
            return@withContext tdao.loadTasks()
    }

    suspend fun search(searchWord: String) : List<Task> =
        withContext(Dispatchers.IO){
            return@withContext tdao.search(searchWord)
    }

    suspend fun save(task_name:String){
            val newTask = Task(0,task_name)
            tdao.save(newTask)

    }
    suspend fun update(task_id: Int, task_name: String) {
        withContext(Dispatchers.IO) {
            val updatedTask = Task(task_id, task_name)
            tdao.update(updatedTask)
        }
    }
    suspend fun delete(task_id: Int){
            val deletedTask = Task(task_id,"")
            tdao.delete(deletedTask)
    }
}