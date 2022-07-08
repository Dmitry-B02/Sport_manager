package com.example.sportmanager.domain.usecase

import com.example.sportmanager.domain.models.trainings.SaveTrainingParam
import com.example.sportmanager.domain.repository.TrainingRepository

class NewTrainingUseCase(private val trainingRepository: TrainingRepository) {
    fun execute(trainingName: SaveTrainingParam): Boolean {
        // open extra window to write training name
        // and then add it to recyclerView
        val res = trainingRepository.newTraining(trainingName)
        return res
    }
}