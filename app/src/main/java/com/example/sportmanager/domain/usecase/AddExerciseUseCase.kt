package com.example.sportmanager.domain.usecase

import com.example.sportmanager.data.repository.ExerciseRepImpl
import com.example.sportmanager.domain.models.exercises.NewExerciseParam

class AddExerciseUseCase(private val exerciseRepImpl: ExerciseRepImpl) {
    fun execute(newExerciseParam: NewExerciseParam): Boolean {
        return exerciseRepImpl.addExercise(newExerciseParam)
    }
}