package com.example.sportmanager.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportmanager.R
import com.example.sportmanager.domain.models.trainings.Training
import com.example.sportmanager.presentation.TrainingPopUp
import com.example.sportmanager.presentation.trainingdetail.TrainingDetailActivity

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        vm = ViewModelProvider(this, MainViewModelFactory(this))
            .get(MainViewModel::class.java)

        val trainingAdapter = TrainingAdapter(vm.trainingList) {
            training -> adapterOnClick(training)
        }
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = trainingAdapter

        val newTrainingButton = findViewById<Button>(R.id.new_training_button)
        val newExerciseButton = findViewById<Button>(R.id.new_exercise_button)


        newTrainingButton.setOnClickListener {
            val intent = Intent(this, TrainingPopUp::class.java)
            startActivityForResult(intent, 2)
        }

        newExerciseButton.setOnClickListener {

        }

        vm.trainingLive.observe(this) {
            it?.let {
                trainingAdapter.submitList(it)
                println("GOT IT GOT IT GOT IT")
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 2) {
            val param = data?.getStringExtra("PARAM")
            if (data != null) {
                vm.save(param!!)
            }
        }
    }

    private fun adapterOnClick(training: Training) {
        Log.e("POPUP", "TRAINING ${training.name.name} WAS CLICKED")
        val intent = Intent(this, TrainingDetailActivity::class.java)
        intent.putExtra("TRAINING", training.name.name)
        startActivity(intent)
    }
}