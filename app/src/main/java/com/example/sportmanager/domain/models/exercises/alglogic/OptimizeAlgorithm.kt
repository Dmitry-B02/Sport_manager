package com.example.sportmanager.domain.models.exercises.alglogic

import android.util.Log
import com.example.sportmanager.domain.models.exercises.Exercise
import com.example.sportmanager.domain.models.exercises.ExerciseList
import java.lang.Exception
import java.util.*

class OptimizeAlgorithm {
    fun getExerciseTime(exercise: Exercise): Int { // Returns time estimation in seconds
        val movesCount: Int
        movesCount = exercise.sets * exercise.reps
        val breakTime = 120 // CONST BREAK BETWEEN SETS
        val timeAmount = movesCount * exercise.logic.exerciseTime + breakTime * (exercise.sets - 1)
        return timeAmount
    }


    fun getTrainingTime(exerciseList: ExerciseList): Int {
        var totalTime = 0.0
        var repAmount = 0
        var prevMuscleGroupArray = listOf<Double>()

        fun convertToK(repAmount: Int): Double { // some float debuff coefficient
            val debuff = 0.15
            return 1 + repAmount * debuff
        }

        for (exercise in exerciseList.getList().value!!) {
            val currentMuscleGroupArray = exercise.logic.getMuscleGroupArray()
            if (currentMuscleGroupArray == prevMuscleGroupArray) {
                repAmount++
            } else {
                repAmount = 0
                prevMuscleGroupArray = currentMuscleGroupArray
            }

            val exerciseTime = getExerciseTime(exercise)
            Log.e("A", "COUNT EXERCISE $exerciseTime")

            if (repAmount == 0) {
                totalTime += exerciseTime
            } else {
                totalTime += exerciseTime * convertToK(repAmount)
            }
        }
        Log.e("A", "COUNT $totalTime")
        return totalTime.toInt()
    }

    fun optimizeTraining(exerciseList: ExerciseList): List<Exercise> {
        val inputList = exerciseList.getList().value?.toMutableList()
        var outputList = mutableListOf<Exercise>()

        if (inputList == null) {
            return listOf()
        }

        for (i in 0 until inputList.size - 2) {
            val currentExerciseMuscleGroup = inputList[i].logic.getMuscleGroupArray()
            if (currentExerciseMuscleGroup == inputList[i + 1].logic.getMuscleGroupArray()) {
                var k = i + 2
                while (k < inputList.size) {
                    Log.e("SOSA",
                        (currentExerciseMuscleGroup != inputList[k].logic.getMuscleGroupArray()).toString()
                    )
                    Log.e("SOSA",
                        "$currentExerciseMuscleGroup, ${inputList[k].logic.getMuscleGroupArray()}"
                    )
                    Log.e("SOSA",
                        "i $i, k $k"
                    )
                    if (currentExerciseMuscleGroup != inputList[k].logic.getMuscleGroupArray()) {
                        Log.e("SOSA SWAP", "before $inputList")
                        Collections.swap(inputList, i + 1, k)
                        Log.e("SOSA SWAP", "after $inputList")
                        break
                    }
                    k++
                }
            }
        }

        for (i in inputList.size - 1 downTo 1) {
            val currentExerciseMuscleGroup = inputList[i].logic.getMuscleGroupArray()
            if (currentExerciseMuscleGroup == inputList[i - 1].logic.getMuscleGroupArray()) {
                var k = i - 2
                while (k >= 0) {
                    Log.e("SOSA BACK",
                        (currentExerciseMuscleGroup != inputList[k].logic.getMuscleGroupArray()).toString()
                    )
                    Log.e("SOSA BACK",
                        "$currentExerciseMuscleGroup, ${inputList[k].logic.getMuscleGroupArray()}"
                    )
                    Log.e("SOSA BACK",
                        "i $i, k $k"
                    )
                    if (currentExerciseMuscleGroup != inputList[k].logic.getMuscleGroupArray()) {
                        Collections.swap(inputList, i - 1, k)
                        break
                    }
                    k--
                }
            }
        }
        return inputList
    }
}