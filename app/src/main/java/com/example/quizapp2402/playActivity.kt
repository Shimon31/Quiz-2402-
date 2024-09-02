package com.example.quizapp2402

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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
    var updateQuestion = 1
    var hasFinished = false

    var skip = -1
    var correct = 0
    var wrong = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initQuestion()

        binding.nextBtn.setOnClickListener {

            showNextQuestion()

        }


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

    private fun showNextQuestion() {
        checkAnswer()

        binding.apply {
            if (updateQuestion < quizList.size) {
                updateQuestion++
                initQuestion()

            } else if (index <= quizList.size - 1) {

                index++

            }else{
                hasFinished = true
            }

            radioGroup.clearCheck()

        }



    }

    private fun checkAnswer() {

        binding.apply {

        if (radioGroup.checkedRadioButtonId == -1){
            skip++

        }else{

            val checkButton = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
            val checkAnswer = checkButton.text.toString()

            if (checkAnswer == quizList[index].answer){
                correct++
                showAlertDialouge("Correct Answer")
            }else{
                wrong++
                showAlertDialouge("Wrong Answer")
            }



        }

            if (index<=quizList.size -1){
                index++

            }else{
                showAlertDialouge("Finished")
            }





        }

    }


    fun showAlertDialouge(message:String){

        val builder = AlertDialog.Builder(this)
        builder.setTitle(message)

        builder.setPositiveButton("ok",object : DialogInterface.OnClickListener{
            override fun onClick(p0: DialogInterface?, p1: Int) {

                if (message =="Finished" ){

                    val intent = Intent(this@playActivity,ResultActivity::class.java)

                    intent.putExtra("skip",skip)
                    intent.putExtra("Correct",correct)
                    intent.putExtra("wrong",wrong)



                    startActivity(intent)

                }


            }


        })


        val alertDialog = builder.create()
        alertDialog.show()


    }


}