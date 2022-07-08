package com.example.sportmanager.domain.models.exercises

import com.example.sportmanager.domain.models.exercises.alglogic.ExerciseLogic

class Exercise(
    val id: Long,
    val logic: ExerciseLogic,
    val sets: Int,
    val reps: Int
)