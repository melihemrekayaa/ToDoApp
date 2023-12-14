package com.mobile.todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.todoapp.data.entity.Task
import com.mobile.todoapp.data.repo.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainpageViewModel @Inject constructor(var trepo: TaskRepository) :ViewModel(){
    var taskList = MutableLiveData<List<Task>>()

    init {
        loadTasks()
    }

    fun loadTasks(){
        CoroutineScope(Dispatchers.Main).launch {
            taskList.value = trepo.loadTasks()
        }
    }

    fun search(searchWord: String){
        CoroutineScope(Dispatchers.Main).launch {
            val searchResult = trepo.search(searchWord)
            taskList.value = searchResult
        }
    }
    fun delete(task_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            trepo.delete(task_id)
            loadTasks()
        }
    }

}