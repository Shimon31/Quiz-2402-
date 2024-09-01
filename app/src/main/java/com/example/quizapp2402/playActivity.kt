package com.example.quizapp2402

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp2402.databinding.ActivityPlayBinding

class playActivity : AppCompatActivity() {

    lateinit var binding: ActivityPlayBinding

    val quizList = listOf<Quiz>(

        Quiz(
            "Victory Day of Bangladesh?",
            "21 February",
            "26 March",
            "5 August",
            "16 December",
            "16 December"
        ),

        Quiz(
            "Independence Day of Bangladesh?",
            "21 February",
            "26 March",
            "5 August",
            "16 December",
            "26 March"
        ),
        Quiz(
            "International Mother Language day of Bangladesh?",
            "21 February",
            "26 March",
            "5 August",
            "16 December",
            "21 February"
        ),
        Quiz(
            "Valentine day?",
            "7 march",
            "29 Februry",
            "21 February",
            "14 February",
            "14 February"
        )


    )

    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initQuestion()


    }

    private fun initQuestion() {
        val quiz = quizList[index]

        binding.apply {

            questionTv.text = quiz.question
            optionBtn1.text = quiz.option1
            optionBtn2.text = quiz.option2
            optionBtn3.text = quiz.option3
            optionBtn4.text = quiz.option4
        }




    }
}