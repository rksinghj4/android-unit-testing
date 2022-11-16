package com.example.edittextuitestdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.edittextuitestdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSubmit.setOnClickListener {
            val msgToPass = "Title - ${binding.titleInput.text} | Desc - ${binding.descriptionInput.text}"
            SecondActivity.showActivity(this, msgToPass)
        }
    }
}