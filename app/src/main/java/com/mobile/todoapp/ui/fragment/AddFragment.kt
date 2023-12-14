package com.mobile.todoapp.ui.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mobile.todoapp.R
import com.mobile.todoapp.databinding.FragmentAddBinding
import com.mobile.todoapp.ui.viewmodel.AddViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : Fragment() {
private lateinit var binding: FragmentAddBinding
private lateinit var viewModel: AddViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AddViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add,container,false)
        binding.addFragment = this
        binding.taskAddToolbarTitle = "Add Task"
        return binding.root
    }

    fun save(task_name: String){
        viewModel.save(task_name)

        findNavController().navigateUp()
    }

}