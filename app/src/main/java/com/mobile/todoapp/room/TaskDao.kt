package com.mobile.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mobile.todoapp.data.entity.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM toDos")
    suspend fun loadTasks(): List<Task>

    @Insert
    suspend fun save(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM toDos WHERE task_name like '%' || :searchWord || '%'")
    suspend fun search(searchWord: String) : List<Task>
}