package com.example.lovecalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.ActivityMainBinding
import com.example.lovecalculator.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Response

class FirstFragment : Fragment() {
    lateinit var binding : FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }
    private fun initClickers() {
        with(binding){
            calculateBtn.setOnClickListener{
                RetrofitService().api.persentageNames(
                    firstNameEd.text.toString(),
                    secondNameEd.text.toString()
                ).enqueue( object :retrofit2.Callback<LoveModel>{
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {

                        if (response.isSuccessful)
                        { Log.e("ololo","onResponse:${response.body()}")
                            findNavController().navigate(R.id.secondFragment, bundleOf("KEY" to response.body()))
                        }

                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo","onFailure:${t.message}")
                    }

                })
            }
        }
    }}