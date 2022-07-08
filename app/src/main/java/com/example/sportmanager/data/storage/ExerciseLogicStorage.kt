package com.example.sportmanager.data.storage

import com.example.sportmanager.domain.models.exercises.alglogic.ExerciseLogic
import com.example.sportmanager.domain.models.exercises.alglogic.MusclesArray

class ExerciseLogicStorage {
    val exerciseMusclesArrayList = listOf(
        listOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0),
        listOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0),
        listOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0),
        listOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0),
        listOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0),
        listOf(0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0)
    )
    val pushUpsMuscles = MusclesArray(exerciseMusclesArrayList[0])
    val pullUpsMuscles = MusclesArray(exerciseMusclesArrayList[1])
    val benchPressMuscles = MusclesArray(exerciseMusclesArrayList[2])
    val sitUpsMuscles = MusclesArray(exerciseMusclesArrayList[3])
    val vertThrustMuscles = MusclesArray(exerciseMusclesArrayList[4])
    val abdCrunchMuscles = MusclesArray(exerciseMusclesArrayList[5])

    val exerciseLogicList = listOf(
        ExerciseLogic("Push ups",3, pushUpsMuscles),
        ExerciseLogic("Pull ups",5, pullUpsMuscles),
        ExerciseLogic("Bench press", 5, benchPressMuscles),
        ExerciseLogic("Sit ups", 3, sitUpsMuscles),
        ExerciseLogic("Vert thrust", 4, vertThrustMuscles),
        ExerciseLogic("Abd crunch", 2, abdCrunchMuscles)
    )
}