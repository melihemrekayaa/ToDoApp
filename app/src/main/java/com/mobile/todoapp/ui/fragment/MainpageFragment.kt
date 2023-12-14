package com.mobile.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.mobile.todoapp.R
import com.mobile.todoapp.databinding.FragmentMainpageBinding
import com.mobile.todoapp.transition
import com.mobile.todoapp.ui.adapter.TaskAdapter
import com.mobile.todoapp.ui.viewmodel.MainpageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainpageFragment : Fragment() {
    private lateinit var binding : FragmentMainpageBinding
    private lateinit var viewModel: MainpageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : MainpageViewModel by viewModels()
        viewModel = tempViewModel


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadTasks()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_mainpage,container,false)
        binding.mainPageFragment = this
        binding.mainpageToolbarTitle = "Tasks"

        viewModel.taskList.observe(viewLifecycleOwner){
            val taskAdapter = TaskAdapter(requireContext(),it,viewModel)
            binding.taskAdapter = taskAdapter
        }


        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }

            override fun onQueryTextChange(query: String): Boolean {
                viewModel.search(query)
                return true
            }
        })

        return binding.root
    }

    fun fabClick(it: View){
        Navigation.transition(it,R.id.action_mainpageFragment_to_addFragment)
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadTasks()
    }
}