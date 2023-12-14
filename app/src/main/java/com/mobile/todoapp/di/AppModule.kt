package com.mobile.todoapp.di

import android.content.Context
import androidx.room.Room
import com.mobile.todoapp.data.datasource.TaskDataSource
import com.mobile.todoapp.data.repo.TaskRepository
import com.mobile.todoapp.room.Database
import com.mobile.todoapp.room.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideTaskDataSource(tdao: TaskDao): TaskDataSource {
        return TaskDataSource(tdao)
    }
    @Provides
    @Singleton
    fun provideTaskRepository(tds: TaskDataSource): TaskRepository{
        return TaskRepository(tds)
}
    @Provides
    @Singleton
    fun provideTaskDao(@ApplicationContext context: Context): TaskDao {
        val vt = Room.databaseBuilder(context, Database::class.java,"guide.sqlite")
            .createFromAsset("guide.sqlite").build()
        return vt.getTaskDao()
    }
}