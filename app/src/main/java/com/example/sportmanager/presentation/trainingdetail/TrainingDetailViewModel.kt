package com.example.sportmanager.presentation.trainingdetail

import androidx.lifecycle.ViewModel
import com.example.sportmanager.domain.models.exercises.ExerciseList
import com.example.sportmanager.domain.models.exercises.NewExerciseParam
import com.example.sportmanager.domain.models.exercises.alglogic.OptimizeAlgorithm
import com.example.sportmanager.domain.usecase.AddExerciseUseCase

class TrainingDetailViewModel(
    var exerciseList: ExerciseList,
    private val addExerciseUseCase: AddExerciseUseCase
): ViewModel() {

    var exerciseLive = exerciseList.getList()
    val optimizeAlgorithm = OptimizeAlgorithm()
    var totalNonOptimized = 0
    var totalDifference = 0

    fun optimize() {
        exerciseList.replace(optimizeAlgorithm.optimizeTraining(exerciseList))
    }

    fun add(name: String, sets: Int, reps: Int) {
        val param = NewExerciseParam(name, sets, reps)
        addExerciseUseCase.execute(param)
    }
}