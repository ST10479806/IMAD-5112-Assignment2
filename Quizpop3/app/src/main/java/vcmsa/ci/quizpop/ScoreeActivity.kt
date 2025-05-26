package vcmsa.ci.quizpop

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_scoree)

        // Shows final score, personalized feedback, and allows review of flashcards

        val txtFinalScore = findViewById<TextView>(R.id.txTFinalScore)
        val btnReview = findViewById<Button>(R.id.btnReview)
        val btnDone = findViewById<Button>(R.id.btnDone)


        val score = intent.getIntExtra("score", 0)
        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        val feedback = if (score >= 3) "Great Job!" else "Keep practicing"

        val total = 5
        txtFinalScore.text = "Your final results = $score out of $total "

        btnReview.setOnClickListener {
            val intent = Intent(this, QuizReview::class.java)
            questions?.let { intent.putExtra("QUESTIONS", it) }
            answers?.let { intent.putExtra("ANSWER", it) }
            startActivity(intent)
        }

        btnDone.setOnClickListener {
            finishAffinity()
        }

            //Exit the app
            btnDone.setOnClickListener {
                finishAffinity()
            }







            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }





