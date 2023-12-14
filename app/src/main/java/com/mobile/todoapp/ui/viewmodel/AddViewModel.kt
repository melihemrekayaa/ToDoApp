package com.mobile.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.mobile.todoapp.data.repo.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(var trepo: TaskRepository) :ViewModel() {

    fun save(task_name:String){
        CoroutineScope(Dispatchers.IO).launch {
            trepo.save(task_name)
        }
    }
}