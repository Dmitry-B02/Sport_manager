package com.example.sportmanager.data.storage

import com.example.sportmanager.domain.models.trainings.Training

interface TrainingStorage {
    fun saveTraining(training: Training): Boolean

    fun getTraining(): Training
}