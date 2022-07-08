package com.example.sportmanager.presentation.trainingdetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportmanager.R
import com.example.sportmanager.domain.models.exercises.Exercise
import com.example.sportmanager.presentation.ExercisePopUp
import com.example.sportmanager.presentation.main.MainViewModel
import org.w3c.dom.Text

class TrainingDetailActivity : AppCompatActivity() {

    private lateinit var vm: TrainingDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_training_detail)

        val addExerciseButton: Button = findViewById(R.id.add_exercise_button)
        val trainingName: TextView = findViewById(R.id.training_header_text)
        val totalText: TextView = findViewById(R.id.total_time_text)
        val optimizeButton: Button = findViewById(R.id.optimize_button)
        val differenceText: TextView = findViewById(R.id.time_difference_text)

        vm = ViewModelProvider(this, TrainingDetailViewModelFactory(this)).get(
            TrainingDetailViewModel::class.java
        )

        val exerciseAdapter = ExerciseAdapter(vm.exerciseList) { exercise ->
            adapterOnClick(exercise)
        }
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view_exercise)
        recyclerView.adapter = exerciseAdapter

        trainingName.text = intent.getStringExtra("TRAINING")

        addExerciseButton.setOnClickListener {
            val intent = Intent(this, ExercisePopUp::class.java)
            startActivityForResult(intent, 3)
        }

        optimizeButton.setOnClickListener {
            vm.totalNonOptimized = vm.optimizeAlgorithm.getTrainingTime(vm.exerciseList)
            vm.optimize()
            optimizeButton.text = "Optimized!"
        }

        vm.exerciseLive.observe(this) {
            it.let {
                exerciseAdapter.submitList(it)
                val total = vm.optimizeAlgorithm.getTrainingTime(vm.exerciseList)
                vm.totalDifference = vm.totalNonOptimized - total
                if (vm.totalNonOptimized != 0) {
                    differenceText.text = "(- ${vm.totalDifference})"
                }
                totalText.text = "Total: $total seconds "
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 3) {
            val name = data?.getStringExtra("EXERCISE")
            val sets = data?.getStringExtra("SETS")?.toInt()
            val reps = data?.getStringExtra("REPS")?.toInt()
            vm.add(name!!, sets!!, reps!!)
        }
    }

    fun adapterOnClick(exercise: Exercise) {

    }
}