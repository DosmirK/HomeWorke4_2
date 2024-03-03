package com.example.homeworke4_2.content

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homeworke4_2.App
import com.example.homeworke4_2.R
import com.example.homeworke4_2.databinding.FragmentCalculatorBinding
import com.example.homeworke4_2.databinding.FragmentHistoryBinding
import com.example.homeworke4_2.remote.LoveModel

class HistoryFragment : Fragment() {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = App.appDatabase.loveDao().getAll()
        list.forEach{
            binding.tvResult.append(it.parseToString())
        }
    }

    fun LoveModel.parseToString(): String{
        return "Ferst name: ${fname}\nSecond name: ${sname}\nPercentage: ${percentage}\nResult: ${result}\n\n"
    }

}