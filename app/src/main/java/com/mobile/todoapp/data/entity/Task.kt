package com.mobile.todoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "toDos")
data class Task(@PrimaryKey(autoGenerate = true)
                @ColumnInfo(name = "task_id") var task_id: Int,
                @ColumnInfo(name = "task_name") var task_name: String
                ) : Serializable {
}