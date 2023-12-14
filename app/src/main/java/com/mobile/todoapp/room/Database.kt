package com.mobile.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mobile.todoapp.data.entity.Task

@Database(entities = [Task::class], version = 1)
abstract class Database : RoomDatabase() {
        abstract fun getTaskDao() : TaskDao
}