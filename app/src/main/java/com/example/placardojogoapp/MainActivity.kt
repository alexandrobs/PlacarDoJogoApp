package com.example.placardojogoapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.placardojogoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var scoreTeamOne = 0
    private var scoreTeamTwo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            scoreTeamOne = savedInstanceState.getInt("scoreTeamOne", 0)
            scoreTeamTwo = savedInstanceState.getInt("scoreTeamTwo", 0)
        }

        binding.teamOneScore.text = scoreTeamOne.toString()
        binding.teamTwoScore.text = scoreTeamTwo.toString()

        binding.teamOnePlus.setOnClickListener {
            scoreTeamOne++
            binding.teamOneScore.text = scoreTeamOne.toString()
        }

        binding.teamTwoPlus.setOnClickListener {
            scoreTeamTwo++
            binding.teamTwoScore.text = scoreTeamTwo.toString()
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
    }
}