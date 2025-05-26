package vcmsa.ci.quizpop

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizReview : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz_review)


        val txtAnswer = findViewById<TextView>(R.id.txtAnswer)
        val txtAnswer2 = findViewById<TextView>(R.id.txtAnswer2)
        val txtAnswer3 = findViewById<TextView>(R.id.txtAnswer3)
        val txtAnswer4 = findViewById<TextView>(R.id.txtAnswer4)
        val txtAnswer5 = findViewById<TextView>(R.id.txtAnswer5)










        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}