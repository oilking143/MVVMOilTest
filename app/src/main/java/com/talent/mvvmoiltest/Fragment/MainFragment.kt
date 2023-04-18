package com.talent.mvvmoiltest.Fragment

import Model.TestModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.talent.mvvmoiltest.databinding.FragmentMainBinding

class MainFragment :BaseFragment(){
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: TestModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity())[TestModel::class.java]
        binding.button.setOnClickListener {

            model.sendMessage(binding.writeMessage.text.toString())

            findNavController().navigate(MainFragmentDirections.actionMainFragmentToMessageFragment())
        }


    }
}