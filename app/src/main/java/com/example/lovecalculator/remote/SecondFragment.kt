package com.example.lovecalculator.remote

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentSecondBinding
import com.example.lovecalculator.remote.LoveModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : Fragment() {
   private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result()
        initListener()
    }

    private fun initListener() {
        binding.btnTryAgain.setOnClickListener {
            (findNavController().navigateUp())
        }
    }

    @SuppressLint("SetTextI18n")
    private fun result() {
        binding.apply {
            val result = arguments?.getSerializable("result") as LoveModel
            tvYou.text = result.firstName
            tvMe.text = result.secondName
            tvPercent.text = result.percentage + "%"
            tvResult.text = result.result
        }
    }
    }


