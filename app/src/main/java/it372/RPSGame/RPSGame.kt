/*
Mya Von Behren
Project 5
June 6, 2024

RPSGame sets up the Rock, Paper, Scissors game through the play method.
The play method randomizes the computer's choice using the Random class.
It then compares the computer's choice to the human's choice and stores the outcome
in a string. Based on the outcome, it updates the scores.
 The reset method sets both the human and computer's scores back to 0.

 */

package it372.RPSGame

import kotlin.random.Random

class RPSGame {
    var humanPlay = ""
    var computerPlay = ""
    val humanScore : Double
        get() = human_Score
    val computerScore : Double
        get() = computer_Score
    var outcome = ""

    private var human_Score = 0.0
    private var computer_Score = 0.0

    fun play (){
        val randomNumber = Random.nextInt(3)
        when (randomNumber) {
            0 -> computerPlay = "Rock"
            1 -> computerPlay = "Paper"
            2 -> computerPlay = "Scissors"
        }

        val outcome: String = when {
            humanPlay == computerPlay -> "Tie"
            humanPlay == "Rock" && computerPlay == "Scissors" ||
                    humanPlay == "Paper" && computerPlay == "Rock" ||
                    humanPlay == "Scissors" && computerPlay == "Paper" -> "Human"
            else -> "Computer"
        }

        when (outcome) {
            "Human" -> human_Score+=1.0
            "Computer" -> computer_Score+=1.0
            "Tie" -> {
                human_Score += 0.5
                computer_Score += 0.5
            }
        }

    }

    fun reset () {
        human_Score = 0.0;
        computer_Score = 0.0;
    }

}