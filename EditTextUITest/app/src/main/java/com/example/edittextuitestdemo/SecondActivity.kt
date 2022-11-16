package com.example.edittextuitestdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.edittextuitestdemo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textToShow.text =  intent.extras?.get(DATA_KEY) as String
    }

    companion object {
        const val DATA_KEY = "data"
        fun showActivity(fromActivity: MainActivity, data: String) {
            val intent = Intent(fromActivity, SecondActivity::class.java)
            intent.putExtra(DATA_KEY, data)
            fromActivity.startActivity(intent)
        }
    }
}