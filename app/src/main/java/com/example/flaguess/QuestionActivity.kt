package com.example.flaguess

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuestionActivity : AppCompatActivity(),View.OnClickListener {

    private var vCurrentPosition:Int = 1
    private lateinit var vQuestionsList:ArrayList<Question?>
    private var vSelectedOptionPosition:Int = 0
    private var vCorrect:Int = 0
    private var vUserName:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        window.statusBarColor = Color.TRANSPARENT
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        setContentView(R.layout.activity_question)
        vUserName = intent.getStringExtra(Constants.USERNAME)

        vQuestionsList = Constants.getQuestions()

        val question = vQuestionsList!![vCurrentPosition-1]

        defaultOptionsView()

        if(vCurrentPosition == vQuestionsList!!.size){
            val submit = findViewById(R.id.submitID) as Button
            submit.text = "KRAJ"
        }
        else{
            val submit = findViewById(R.id.submitID) as Button
            submit.text = "POTVRDI"
        }

        val progress = findViewById(R.id.progressBarID) as ProgressBar
        progress.progress = vCurrentPosition

        val progressText = findViewById(R.id.progressTextID) as TextView
        progressText.text = "$vCurrentPosition" + "/" + progress.max

        val questions = findViewById(R.id.questionID) as TextView
        questions.text = question!!.question

        val image = findViewById(R.id.imageID) as ImageView
        image.setImageResource(question.image)

        val optionOne = findViewById(R.id.optionOneID) as TextView
        optionOne.text = question.optionOne

        val optionTwo = findViewById(R.id.optionTwoID) as TextView
        optionTwo.text = question.optionTwo

        val optionThree = findViewById(R.id.optionThreeID) as TextView
        optionThree.text = question.optionThree

        val optionFour = findViewById(R.id.optionFourID) as TextView
        optionFour.text = question.optionFour

        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)

        val submit = findViewById(R.id.submitID) as Button
        submit.setOnClickListener(this)
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        val option1 = findViewById(R.id.optionOneID) as TextView
        val option2 = findViewById(R.id.optionTwoID) as TextView
        val option3 = findViewById(R.id.optionThreeID) as TextView
        val option4 = findViewById(R.id.optionFourID) as TextView
        options.add(0,option1)
        options.add(1,option2)
        options.add(2,option3)
        options.add(3,option4)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_border)
        }
    }

    override fun onClick(v: View?) {
        val option1 = findViewById(R.id.optionOneID) as TextView
        val option2 = findViewById(R.id.optionTwoID) as TextView
        val option3 = findViewById(R.id.optionThreeID) as TextView
        val option4 = findViewById(R.id.optionFourID) as TextView
        when(v?.id) {
            R.id.optionOneID -> {
                defaultOptionsView()
                vSelectedOptionPosition = 1

                option1.setTextColor(Color.parseColor("#363A43"))
                option1.setTypeface(option1.typeface, Typeface.BOLD)
                option1.background = ContextCompat.getDrawable(this, R.drawable.selected_border)
            }

            R.id.optionTwoID -> {
                defaultOptionsView()
                vSelectedOptionPosition = 2

                option2.setTextColor(Color.parseColor("#363A43"))
                option2.setTypeface(option2.typeface, Typeface.BOLD)
                option2.background = ContextCompat.getDrawable(this, R.drawable.selected_border)
            }

            R.id.optionThreeID -> {
                defaultOptionsView()
                vSelectedOptionPosition = 3

                option3.setTextColor(Color.parseColor("#363A43"))
                option3.setTypeface(option3.typeface, Typeface.BOLD)
                option3.background = ContextCompat.getDrawable(this, R.drawable.selected_border)
            }

            R.id.optionFourID ->{
                defaultOptionsView()
                vSelectedOptionPosition = 4

                option4.setTextColor(Color.parseColor("#363A43"))
                option4.setTypeface(option4.typeface, Typeface.BOLD)
                option4.background = ContextCompat.getDrawable(this, R.drawable.selected_border)
            }

            R.id.submitID ->{
                if(vSelectedOptionPosition == 0){
                    vCurrentPosition++

                    when{vCurrentPosition <= vQuestionsList!!.size -> {

                        val question = vQuestionsList!![vCurrentPosition-1]

                        defaultOptionsView()

                        if(vCurrentPosition == vQuestionsList!!.size){
                            val submit = findViewById(R.id.submitID) as Button
                            submit.text = "KRAJ"
                        }
                        else{
                            val submit = findViewById(R.id.submitID) as Button
                            submit.text = "POTVRDI"
                        }

                        val progress = findViewById(R.id.progressBarID) as ProgressBar
                        progress.progress = vCurrentPosition

                        val progressText = findViewById(R.id.progressTextID) as TextView
                        progressText.text = "$vCurrentPosition" + "/" + progress.max

                        val questions = findViewById(R.id.questionID) as TextView
                        questions.text = question!!.question

                        val image = findViewById(R.id.imageID) as ImageView
                        image.setImageResource(question.image)

                        val optionOne = findViewById(R.id.optionOneID) as TextView
                        optionOne.text = question.optionOne

                        val optionTwo = findViewById(R.id.optionTwoID) as TextView
                        optionTwo.text = question.optionTwo

                        val optionThree = findViewById(R.id.optionThreeID) as TextView
                        optionThree.text = question.optionThree

                        val optionFour = findViewById(R.id.optionFourID) as TextView
                        optionFour.text = question.optionFour
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USERNAME,vUserName)
                            intent.putExtra(Constants.CORRECT,vCorrect)
                            intent.putExtra(Constants.QUESTIONS,vQuestionsList!!.size)
                            startActivity(intent)
                        }
                    }
                }
                else{
                    val question = vQuestionsList?.get(vCurrentPosition-1)
                    if(question!!.correctOption != vSelectedOptionPosition){
                        answerView(vSelectedOptionPosition, R.drawable.wrong_option)
                    }
                    else{
                        vCorrect++
                    }
                    answerView(question.correctOption,R.drawable.correct_option)

                    if(vCurrentPosition == vQuestionsList!!.size){
                        val submit = findViewById(R.id.submitID) as Button
                        submit.text = "KRAJ"
                    }
                    else{
                        val submit = findViewById(R.id.submitID) as Button
                        submit.text = "SLEDEĆE PITANJE"
                    }
                    vSelectedOptionPosition = 0
                }
            }
        }
    }


    private fun answerView(answer: Int, drawableView: Int){
        val option1 = findViewById(R.id.optionOneID) as TextView
        val option2 = findViewById(R.id.optionTwoID) as TextView
        val option3 = findViewById(R.id.optionThreeID) as TextView
        val option4 = findViewById(R.id.optionFourID) as TextView
        when(answer){
            1 -> option1.background = ContextCompat.getDrawable(this, drawableView)
            2 -> option2.background = ContextCompat.getDrawable(this, drawableView)
            3 -> option3.background = ContextCompat.getDrawable(this, drawableView)
            4 -> option4.background = ContextCompat.getDrawable(this, drawableView)
        }
    }
}
