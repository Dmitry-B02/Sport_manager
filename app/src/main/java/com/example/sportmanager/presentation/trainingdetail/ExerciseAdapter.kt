package com.example.sportmanager.presentation.trainingdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sportmanager.R
import com.example.sportmanager.domain.models.exercises.Exercise
import com.example.sportmanager.domain.models.exercises.ExerciseList

class ExerciseAdapter(
    private val exercises: ExerciseList,
    private val onClick: (Exercise) -> Unit
) :
    ListAdapter<Exercise, ExerciseAdapter.ExerciseViewHolder>(ExerciseDiffCallback) {

    class ExerciseViewHolder(view: View, val onClick: (Exercise) -> Unit) :
        RecyclerView.ViewHolder(view) {
        val exerciseText: TextView = view.findViewById(R.id.exercise_name)
        val setsText: TextView = view.findViewById(R.id.sets_text)
        val repsText: TextView = view.findViewById(R.id.reps_text)
        var currentExercise: Exercise? = null

        init {
            view.setOnClickListener {
                currentExercise?.let {
                    onClick(it)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.exercise_row_item, parent, false)
        view.apply {
            this.layoutParams = RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
        return ExerciseViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val currentExercise = exercises.getList().value?.get(position)
        holder.currentExercise = currentExercise
        holder.exerciseText.text = currentExercise?.logic?.name
        holder.setsText.text = currentExercise?.sets.toString()
        holder.repsText.text = currentExercise?.reps.toString()
    }

    object ExerciseDiffCallback : DiffUtil.ItemCallback<Exercise>() {
        override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
            return oldItem.id == newItem.id
        }
    }
}