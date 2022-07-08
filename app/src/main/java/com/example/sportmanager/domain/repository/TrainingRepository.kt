package com.example.sportmanager.domain.repository

import com.example.sportmanager.domain.models.trainings.SaveTrainingParam

interface TrainingRepository {
    fun newTraining(saveTrainingParam: SaveTrainingParam): Boolean

    /* TODO()


    fun incId(): Boolean

    fun getId(): Long


    fun removeTraining(training: Training): Boolean

    fun newExercise(exercise: Exercise): Boolean

    fun removeExercise(exercise: Exercise): Boolean
     */
}