package com.example.homeworke4_2.content

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.homeworke4_2.LoveModel
import com.example.homeworke4_2.LoveView
import com.example.homeworke4_2.Presenter
import com.example.homeworke4_2.R
import com.example.homeworke4_2.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment(), LoveView {
    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!
    private val presenter = Presenter(this)

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
        initClicker()
    }

    private fun initClicker() {
        with(binding){
            calculate.setOnClickListener {
                presenter.getPercentage(fNameEt.text.toString(), sNameEt.text.toString())
            }
        }
    }
    private fun openFragment(fragment: Fragment){
        val fragmentManager = parentFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun viewResult(loveModel: LoveModel) {
        val fragment = ResultFragment()
        val result = loveModel.result + "\n%" + loveModel.percentage
        val bundle = Bundle().apply {
            putString("result", result)
        }
        fragment.arguments = bundle
        openFragment(fragment)
    }

    override fun showError(message: String) {
        Log.d("ololo", message)

    }
}