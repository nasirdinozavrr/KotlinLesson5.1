package com.example.kotlinlesson51

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.kotlinintroduction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var num = 0;
    private var reverse: Boolean = false
    private var isButtonCreated: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.number.text = num.toString()
        binding.btn.setOnClickListener {
            if (!isButtonCreated) {
                count(reverse)
                check(binding.number.text.toString())
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun check(text: String?) {
        if (text == "10") {
            reverse = true
        }
        if (text == "0" && reverse) {
            binding.btn.text = "Open activity"
            isButtonCreated = true
        }
    }

    private fun count(check: Boolean?) {
        if (check == false) {
            num++
            binding.number.text = num.toString()
        } else {
            num--
            binding.number.text = num.toString()
        }
    }

}