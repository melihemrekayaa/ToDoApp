package com.mobile.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.mobile.todoapp.data.repo.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var trepo: TaskRepository) : ViewModel() {

    fun update(task_id:Int,task_name:String){
        CoroutineScope(Dispatchers.IO).launch {
                trepo.update(task_id,task_name)
        }

    }
}