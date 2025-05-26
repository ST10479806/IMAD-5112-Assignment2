package vcmsa.ci.quizpop

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        //Display flashcard questions, accepts user input, and keeps track of the score

        val questions = arrayOf(
            "The first Black President of South Africa was Nelson Mandela", //True
            "World War 2 ended in 1942", //False
            "The Berlin Wall fell in 1985", //False
            "Nelson Mandela spent 27 years in prison",//True
            "Ancient Pyramids originate in Egypt", //True
        )
        val answers = arrayOf(true, false, false, true, true)
        var score = 0
        var index = 0

        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val txtQuestions = findViewById<TextView>(R.id.txtQuestions)
        txtQuestions.text = questions[index]



        fun checkAnswer(userAnswer: Boolean) {
            val correct = answers[index]
            if (userAnswer == correct) {
                score++
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
            }
            btnTrue.isEnabled = true
            btnFalse.isEnabled = true
            btnNext.isEnabled = true

        }

        btnTrue.setOnClickListener {
            checkAnswer(true)
        }

        btnFalse.setOnClickListener {
            checkAnswer(false)
        }

        btnNext.setOnClickListener {
            index++
            if (index < questions.size) {
                txtQuestions.text = questions[index]
                btnTrue.isEnabled = true
                btnFalse.isEnabled = false
                btnNext.isEnabled = true
            } else {
                val intent = Intent(this, ScoreeActivity::class.java)
                intent.putExtras("score", score)
                intent.putExtras("Questions", questions)
                startActivity(intent)
                finish()
            }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }


    }
}



