package com.example.sportmanager.domain.models.exercises.alglogic

class ExerciseLogic(
    val name: String,
    val exerciseTime: Int,
    val musclesArray: MusclesArray
) {
    fun getMuscleGroupArray(): List<Double> {
        // NEURAL NETWORK HERE
        val muscleGroupList = listOf<Int>()
        return musclesArray.musclesArray
    }
}