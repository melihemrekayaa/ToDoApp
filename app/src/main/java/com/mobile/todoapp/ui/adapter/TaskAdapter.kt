package com.mobile.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.snackbar.Snackbar
import com.mobile.todoapp.R
import com.mobile.todoapp.data.entity.Task
import com.mobile.todoapp.databinding.CardDesignBinding
import com.mobile.todoapp.transition
import com.mobile.todoapp.ui.fragment.MainpageFragmentDirections
import com.mobile.todoapp.ui.viewmodel.MainpageViewModel

class TaskAdapter(var mContext: Context, var tasksList: List<Task>,var viewModel: MainpageViewModel)
    : RecyclerView.Adapter<TaskAdapter.CardDesignHolder>()
{
inner class CardDesignHolder(var design: CardDesignBinding) : ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding: CardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
            R.layout.card_design,parent,false)
        return CardDesignHolder(binding)
    }



    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val task = tasksList.get(position)
        val design = holder.design

        design.taskObject = task

        design.cardViewRow.setOnClickListener {
            val action = MainpageFragmentDirections.actionMainpageFragmentToDetailFragment(task = task)
            Navigation.transition(it,action)
        }

        design.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Are you sure you want to delete Task${ task.task_id} ?", Snackbar.LENGTH_LONG)
                .setAction("YES"){
                    viewModel.delete(task.task_id)
                }
                .show()
        }


    }

    override fun getItemCount(): Int {
        return tasksList.size
    }


}