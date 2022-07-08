package com.example.sportmanager.domain.repository

import com.example.sportmanager.domain.models.exercises.NewExerciseParam

interface ExerciseRepository {
    fun addExercise(newExerciseParam: NewExerciseParam): Boolean
}