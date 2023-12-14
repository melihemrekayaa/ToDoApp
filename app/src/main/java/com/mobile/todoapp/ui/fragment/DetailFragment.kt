package com.mobile.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mobile.todoapp.R
import com.mobile.todoapp.databinding.FragmentDetailBinding
import com.mobile.todoapp.ui.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : DetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)
        binding.detailFragment = this
        binding.taskDetailToolbarTitle = "Task Detail"

        val bundle : DetailFragmentArgs by navArgs()
        val takenTask = bundle.task
        binding.taskObject = takenTask



        return binding.root
    }

    fun update(task_id:Int,task_name: String){
        viewModel.update(task_id,task_name)
        findNavController().navigateUp()
    }


}