package vcmsa.ci.flashcardhistoryapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)

        val questions = intent.getStringArrayExtra("questions") ?:arrayof()
        val answers = intent.getBooleanArrayExtra("answers")?: booleanArrayOf()

        val txtReview = findViewById<TextView>(R.id.txtReview)
        val reviewText = StringBuilder()

        for (i in questions.indices) {
            review.append("Q${i + 1}: ${questions[i]} \n")
            reviewText.append("Answer: ${if (answer[i]) "True" else "False"}\n\n")
    }

    txtReview.text = reviewText.toString()
    }
}