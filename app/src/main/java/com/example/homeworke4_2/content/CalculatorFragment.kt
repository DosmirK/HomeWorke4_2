package com.example.homeworke4_2.content

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.homeworke4_2.LoveViewModel
import com.example.homeworke4_2.remote.LoveModel
import com.example.homeworke4_2.R
import com.example.homeworke4_2.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment() {
    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            calculate.setOnClickListener {
                viewModel.getPercentage(fNameEt.text.toString(), sNameEt.text.toString())
                    .observe(viewLifecycleOwner) {
                        val result = it

                        viewResult(it)
                    }
            }
        }
    }
    private fun viewResult(loveModel: LoveModel) {
        val fragment = ResultFragment()
        val collocated = loveModel.fname + " + " + loveModel.sname + "\n"
        val result = collocated + loveModel.percentage + "%" + "\n" + loveModel.result
        val bundle = Bundle().apply {
            putString("result", result)
        }
        fragment.arguments = bundle
        openFragment(fragment)
    }

    private fun openFragment(fragment: Fragment) {
        val fragmentManager = parentFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}