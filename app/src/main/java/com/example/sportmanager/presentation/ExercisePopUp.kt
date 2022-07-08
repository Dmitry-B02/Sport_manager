package com.example.sportmanager.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.example.sportmanager.R

class ExercisePopUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_pop_up)

        val spinner: Spinner = findViewById(R.id.spinner)
        val submitButton: Button = findViewById(R.id.submit_exercise_button)
        val setsEditText: EditText = findViewById(R.id.sets_amount_text)
        val repsEditText: EditText = findViewById(R.id.reps_amount_text)

        ArrayAdapter.createFromResource(
            this,
            R.array.exercises_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        submitButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("EXERCISE", spinner.selectedItem.toString())
            Log.e("EX", spinner.selectedItem.toString())
            intent.putExtra("SETS", setsEditText.text.toString())
            intent.putExtra("REPS", repsEditText.text.toString())
            setResult(3, intent)
            finish()
        }
    }
}