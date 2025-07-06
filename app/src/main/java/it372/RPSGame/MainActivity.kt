/*
Mya Von Behren
Project 5
June 6, 2024

Main Activity sets up the user interface for this game. It manages user input
through radio buttons, initiates the game by calling RPSGame, and updates the UI
with image results and scores.

 */

package it372.RPSGame
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    private lateinit var game: RPSGame

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        game = RPSGame()

        // UI Elements
        var radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        var playButton = findViewById<Button>(R.id.play_btn)
        var txtPlayerScore = findViewById<TextView>(R.id.player_score)
        var txtComputerScore = findViewById<TextView>(R.id.computer_score)
        var playerOutcome = findViewById<ImageView>(R.id.player_outcome)
        var computerOutcome = findViewById<ImageView>(R.id.computer_outcome)
        var resetButton = findViewById<Button>(R.id.reset_btn)

        playButton.setOnClickListener {
            //  Get human choice from selected radio button
            //  Change player image view to human choice
            val selectedId = radioGroup.checkedRadioButtonId
            when (selectedId) {
                R.id.rock_btn -> {
                    playerOutcome.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.rock))
                    game.humanPlay = "Rock"
                }

                R.id.paper_btn -> {
                    playerOutcome.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.paper))
                    game.humanPlay = "Paper"
                }

                R.id.scissors_btn -> {
                    playerOutcome.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.scissors))
                    game.humanPlay = "Scissors"
                }
            }

            // Play the game
            game.play()

            //  Get computer choice from selected radio button
            //  Change computer image view to computer choice
            when (game.computerPlay) {
                "Rock" -> computerOutcome.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.rock))
                "Paper" -> computerOutcome.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.paper))
                "Scissors" -> computerOutcome.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.scissors))
            }


            // Updates the text view of both players based on results
            txtPlayerScore.text =
                getString(R.string.player_score_txt_view, game.humanScore.toString())
            txtComputerScore.text =
                getString(R.string.computer_score_txt_view, game.computerScore.toString())
        }


        // Resets the scores to 0 using the reset method from RPSGame
        resetButton.setOnClickListener {
            game.reset()

            // Updates the text view of both players to 0
            txtPlayerScore.text =
                getString(R.string.player_score_txt_view, game.humanScore.toString())
            txtComputerScore.text =
                getString(R.string.computer_score_txt_view, game.computerScore.toString())
        }
    }
}

