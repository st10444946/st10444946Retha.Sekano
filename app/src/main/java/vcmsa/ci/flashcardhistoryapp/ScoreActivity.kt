package vcmsa.ci.flashcardhistoryapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("score", 0)
        val questions = intent.getStringArrayExtra("questions") ?: arrayOf()
        val answers = intent.getBooleanArrayExtra("answer") ?: booleanArrayOf()

        val txtScore = findViewById<TextView>(R.id.txtScore)
        val txtFinalFeedback = findViewById<TextView>(R.id.txtFinalFeedback)
        val btnReview = findViewById<Button>(R.id.btnReview)
        val btnExit = findViewById<Button>(R.id.btnExit)

        txtScore.text = "Your score: $score / ${questions.size}"

        txtFinalFeedback.text = if(score>= 3) {
            "Good job!"
        } else {
            "Keep practicing!"
        }

        btnReview.setOnClickListener {
        val intent = Intent (this, ReviewActivity::class.java)
            intent.putExtra("questions", answers)
            startActivity(intent)
        }

        btnExit.setOnClickListener {
            finishAffinity()
        }
    }
}

