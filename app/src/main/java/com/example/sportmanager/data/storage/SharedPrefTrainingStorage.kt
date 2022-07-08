package com.example.sportmanager.data.storage

import com.example.sportmanager.domain.models.exercises.ExerciseList
import com.example.sportmanager.domain.models.trainings.SaveTrainingParam
import com.example.sportmanager.domain.models.trainings.Training

class SharedPrefTrainingStorage: TrainingStorage {
    /* TODO: SHARED PREF */
    override fun saveTraining(training: Training): Boolean {
        return true
    }

    override fun getTraining(): Training {
        val param = SaveTrainingParam("b")
        return Training(1, param, ExerciseList())
    }
}