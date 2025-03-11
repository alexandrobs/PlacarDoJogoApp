package com.example.placardojogoapp

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.placardojogoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var scoreTeamOne = 0
    private var scoreTeamTwo = 0
    private var scoreEqualsGoesToTwo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            Log.d("MainActivity", "savedIntanceState é diferente de nulo")
            scoreTeamOne = savedInstanceState.getInt("scoreTeamOne", 0)
            scoreTeamTwo = savedInstanceState.getInt("scoreTeamTwo", 0)
            scoreEqualsGoesToTwo = savedInstanceState.getInt("scoreEqualsGoesToTwo", 0)
            Log.d("MainActivity", "onCreate scoreTeamOne: $scoreTeamOne")
            Log.d("MainActivity", "onCreate scoreTeamTwo: $scoreTeamTwo")
            Log.d("MainActivity", "onCreate scoreEqualsGoesToTwo: $scoreEqualsGoesToTwo")
        }

        binding.teamOneScore.text = scoreTeamOne.toString()
        binding.teamTwoScore.text = scoreTeamTwo.toString()

        binding.teamOnePlus.setOnClickListener {
            scoreTeamOne++
            binding.teamOneScore.text = scoreTeamOne.toString()

            if (binding.teamOneScore.text.equals("15")){
                Toast.makeText(this, "Time Azul Venceu!", Toast.LENGTH_SHORT).show()
                scoreTeamOne = 0
                scoreTeamTwo = 0
                binding.teamOneScore.text = scoreTeamOne.toString()
                binding.teamTwoScore.text = scoreTeamTwo.toString()
                Toast.makeText(this, "Placar resetado!", Toast.LENGTH_SHORT).show()
            }

            if (binding.teamOneScore.text.equals("14") && binding.teamTwoScore.text.equals("14")) {
                scoreTeamOne = 0
                scoreTeamTwo = 0
                binding.teamOneScore.text = scoreTeamOne.toString()
                binding.teamTwoScore.text = scoreTeamTwo.toString()
                Toast.makeText(this, "14 Iguais vai a 2!", Toast.LENGTH_SHORT).show()
                scoreEqualsGoesToTwo = 1
            }

            if (binding.teamOneScore.text.equals("2") && binding.teamTwoScore.text.equals("2") && scoreEqualsGoesToTwo == 1) {
                scoreTeamOne = 0
                scoreTeamTwo = 0
                binding.teamOneScore.text = scoreTeamOne.toString()
                binding.teamTwoScore.text = scoreTeamTwo.toString()
                Toast.makeText(this, "2 Iguais zerando vai a 2 de novo!", Toast.LENGTH_SHORT).show()
                scoreEqualsGoesToTwo = 1
            }

            if (binding.teamOneScore.text.equals("2") && binding.teamTwoScore.text.equals("0") && scoreEqualsGoesToTwo == 1) {
                Toast.makeText(this, "Time Azul Venceu!", Toast.LENGTH_LONG).show()
                scoreTeamOne = 0
                scoreTeamTwo = 0
                binding.teamOneScore.text = scoreTeamOne.toString()
                binding.teamTwoScore.text = scoreTeamTwo.toString()
                scoreEqualsGoesToTwo = 0
                Toast.makeText(this, "Placar resetado!", Toast.LENGTH_SHORT).show()
            }

            if (binding.teamOneScore.text.equals("3") && binding.teamTwoScore.text.equals("1") && scoreEqualsGoesToTwo == 1) {
                Toast.makeText(this, "Time Azul Venceu!", Toast.LENGTH_LONG).show()
                scoreTeamOne = 0
                scoreTeamTwo = 0
                binding.teamOneScore.text = scoreTeamOne.toString()
                binding.teamTwoScore.text = scoreTeamTwo.toString()
                scoreEqualsGoesToTwo = 0
                Toast.makeText(this, "Placar resetado!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.teamTwoPlus.setOnClickListener {
            scoreTeamTwo++
            binding.teamTwoScore.text = scoreTeamTwo.toString()

            if (binding.teamTwoScore.text.equals("15")){
                Toast.makeText(this, "Time Vermelho Venceu!", Toast.LENGTH_SHORT).show()
                scoreTeamOne = 0
                scoreTeamTwo = 0
                binding.teamOneScore.text = scoreTeamOne.toString()
                binding.teamTwoScore.text = scoreTeamTwo.toString()
                Toast.makeText(this, "Placar resetado!", Toast.LENGTH_SHORT).show()
            }

            if (binding.teamTwoScore.text.equals("14") && binding.teamOneScore.text.equals("14")) {
                scoreTeamOne = 0
                scoreTeamTwo = 0
                binding.teamOneScore.text = scoreTeamOne.toString()
                binding.teamTwoScore.text = scoreTeamTwo.toString()
                Toast.makeText(this, "14 Iguais vai a 2!", Toast.LENGTH_SHORT).show()
                scoreEqualsGoesToTwo = 1
            }

            if (binding.teamTwoScore.text.equals("2") && binding.teamOneScore.text.equals("2") && scoreEqualsGoesToTwo == 1) {
                scoreTeamOne = 0
                scoreTeamTwo = 0
                binding.teamOneScore.text = scoreTeamOne.toString()
                binding.teamTwoScore.text = scoreTeamTwo.toString()
                Toast.makeText(this, "2 Iguais zerando vai a 2 de novo!", Toast.LENGTH_SHORT).show()
                scoreEqualsGoesToTwo = 1
            }

            if (binding.teamTwoScore.text.equals("2") && binding.teamOneScore.text.equals("0") && scoreEqualsGoesToTwo == 1) {
                Toast.makeText(this, "Time Vermelho Venceu!", Toast.LENGTH_LONG).show()
                scoreTeamOne = 0
                scoreTeamTwo = 0
                binding.teamOneScore.text = scoreTeamOne.toString()
                binding.teamTwoScore.text = scoreTeamTwo.toString()
                scoreEqualsGoesToTwo = 0
                Toast.makeText(this, "Placar resetado!", Toast.LENGTH_SHORT).show()
            }

            if (binding.teamTwoScore.text.equals("3") && binding.teamOneScore.text.equals("1") && scoreEqualsGoesToTwo == 1) {
                Toast.makeText(this, "Time Vermelho Venceu!", Toast.LENGTH_LONG).show()
                scoreTeamOne = 0
                scoreTeamTwo = 0
                binding.teamOneScore.text = scoreTeamOne.toString()
                binding.teamTwoScore.text = scoreTeamTwo.toString()
                scoreEqualsGoesToTwo = 0
                Toast.makeText(this, "Placar resetado!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.resetButton.setOnClickListener {
            scoreTeamOne = 0
            scoreTeamTwo = 0
            binding.teamOneScore.text = scoreTeamOne.toString()
            binding.teamTwoScore.text = scoreTeamTwo.toString()
            Toast.makeText(this, "Placar resetado!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("scoreTeamOne", scoreTeamOne)
        outState.putInt("scoreTeamTwo", scoreTeamTwo)
        outState.putInt("scoreEqualsGoesToTwo", scoreEqualsGoesToTwo)
        Log.d("MainActivity", "Destroy scoreTeamOne: $scoreTeamOne")
        Log.d("MainActivity", "Destroy scoreTeamTwo: $scoreTeamTwo")
        Log.d("MainActivity", "Destroy scoreEqualsGoesToTwo: $scoreEqualsGoesToTwo")
    }


}