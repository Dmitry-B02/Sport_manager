package com.example.sportmanager.domain.models.trainings

import com.example.sportmanager.domain.models.exercises.ExerciseList

data class Training(
    val id: Long,
    val name: SaveTrainingParam,
    val exerciseList: ExerciseList
)