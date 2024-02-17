package com.example.homeworke4_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homeworke4_2.content.CalculatorFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CalculatorFragment())
                .commit()

        }
    }
}