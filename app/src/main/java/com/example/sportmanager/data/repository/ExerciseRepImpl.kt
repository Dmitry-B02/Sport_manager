package com.example.sportmanager.data.repository

import com.example.sportmanager.data.storage.ExerciseLogicStorage
import com.example.sportmanager.domain.models.exercises.Exercise
import com.example.sportmanager.domain.models.exercises.ExerciseList
import com.example.sportmanager.domain.models.exercises.NewExerciseParam
import com.example.sportmanager.domain.models.exercises.alglogic.ExerciseLogic
import com.example.sportmanager.domain.repository.ExerciseRepository

class ExerciseRepImpl(private val exerciseList: ExerciseList): ExerciseRepository {
    // TODO: ADD STORAGE

    private var exerciseId: Long = -1
    val exerciseLogicStorage = ExerciseLogicStorage()

    override fun addExercise(newExerciseParam: NewExerciseParam): Boolean {
        val exercise = mapExerciseToStorage(newExerciseParam)
        exerciseList.add(exercise)
        return true // TODO: RETURN STORAGE.SAVE
    }

    private fun mapExerciseToStorage(newExerciseParam: NewExerciseParam): Exercise {
        exerciseId++
        var exerciseLogic: ExerciseLogic? = null
        exerciseLogicStorage.exerciseLogicList.forEach {
            if (it.name == newExerciseParam.name) exerciseLogic = it
        }
        return Exercise(exerciseId, exerciseLogic!!, newExerciseParam.sets, newExerciseParam.reps)
    }
}