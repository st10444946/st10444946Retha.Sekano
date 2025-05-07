package vcmsa.ci.flashcardhistoryapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuestionActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "Barack Obama was president in 2009.",
        "World War II ended in 1945.",
        "The telescope was invented in Germany.",
        "Caesar Augustus was a roman general and statesman.",
        "The Renaissance period took place in the 13th Century."
    )

    private val answers = booleanArrayOf(true, true, false, false, true)

    private var currentIndex = 0
    private var score = 0
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question)

        val txtQuestion = findViewById<TextView>(R.id.txtQuestion)
        val txtFeedback = findViewById<TextView>(R.id.txtFeedback)
        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)
        val btnNext = findViewById<Button>(R.id.btnNext)

        txtQuestion.text = questions[currentIndex]

        fun handleAnswer(userAnswer: Boolean) {
            if (!answered) {
                val correctAnswer = answers [currentIndex]
                if (userAnswer == correctAnswer) {
                    txtFeedback.text = "Correct!"
                    score++
                } else {
                    txtFeedback.text = "Incorrect"
                }
                answered = true
            }
        }

        btnTrue.setOnClickListener { handleAnswer(true) }
        btnFalse.setOnClickListener { handleAnswer(false) }

        btnNext.setOnClickListener {
            if (currentIndex < questions.size - 1) {
                currentIndex++
                txtQuestion.text = questions[currentIndex]
                txtFeedback.text = ""
                answered = false
            } else {
                val intent = Intent(this, scoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("questions", questions)
                intent.putExtra("answers", answers)
                startActivity(intent)
                finish()
            }
        }
    }
}







