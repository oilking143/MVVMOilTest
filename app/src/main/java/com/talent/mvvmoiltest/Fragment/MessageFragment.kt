package com.talent.mvvmoiltest.Fragment

import Model.TestModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.talent.mvvmoiltest.databinding.FragmentMessanerBinding

class MessageFragment :BaseFragment() {
    private var _binding: FragmentMessanerBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMessanerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity())[TestModel::class.java]

        model.message.observe(viewLifecycleOwner, Observer {
            // updating data in displayMsg
            binding!!.textViewReceiver.text = it
        })


    }
}