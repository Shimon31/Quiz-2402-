package com.example.quizapp2402

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp2402.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val skip = intent.getIntExtra("skip", 0)
        val correct = intent.getIntExtra("Correct", 0)
        val wrong = intent.getIntExtra("wrong", 0)

        binding.resultTv.text =
            "Number of Skip : $skip \n" + " Number of Correct : $correct\n" + "Number of wrong : $wrong"


    }
}