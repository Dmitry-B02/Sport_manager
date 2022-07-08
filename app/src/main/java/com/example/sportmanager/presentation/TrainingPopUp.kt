package com.example.sportmanager.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.sportmanager.R

class TrainingPopUp : AppCompatActivity() {
    private lateinit var popupText: TextView
    private lateinit var popupEditText: EditText
    private lateinit var popupButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(0, 0)
        setContentView(R.layout.activity_training_pop_up)

        popupText = findViewById(R.id.popup_text)
        popupEditText = findViewById(R.id.popup_edit_text)
        popupButton = findViewById(R.id.popup_submit_button)

        popupButton.setOnClickListener {
            val saveText = popupEditText.text.toString()
            val intent = Intent()
            intent.putExtra("PARAM", saveText)
            setResult(2, intent)
            finish()
        }
    }
}