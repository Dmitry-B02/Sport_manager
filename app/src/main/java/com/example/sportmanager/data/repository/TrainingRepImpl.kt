package com.example.sportmanager.data.repository

import com.example.sportmanager.data.storage.TrainingStorage
import com.example.sportmanager.domain.models.exercises.ExerciseList
import com.example.sportmanager.domain.models.trainings.SaveTrainingParam
import com.example.sportmanager.domain.models.trainings.Training
import com.example.sportmanager.domain.models.trainings.TrainingList
import com.example.sportmanager.domain.repository.TrainingRepository

class TrainingRepImpl(
    private val trainingList: TrainingList,
    private val trainingStorage: TrainingStorage
) : TrainingRepository {

    var trainingId: Long = -1

    override fun newTraining(saveTrainingParam: SaveTrainingParam): Boolean {
        val training = mapTrainingToStorage(saveTrainingParam)
        trainingList.add(training)
        return trainingStorage.saveTraining(training)
    }

    private fun mapTrainingToStorage(saveTrainingParam: SaveTrainingParam): Training {
        trainingId++
        return Training(trainingId, saveTrainingParam, ExerciseList())
    }
}