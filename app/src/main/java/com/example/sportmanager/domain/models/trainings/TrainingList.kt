package com.example.sportmanager.domain.models.trainings

import androidx.lifecycle.MutableLiveData

class TrainingList {
    private val trainingList: List<Training> = listOf()
    private val trainingLiveData = MutableLiveData(trainingList)

    fun getList(): MutableLiveData<List<Training>> {
        return trainingLiveData
    }

    fun add(training: Training) {
        val currentList = trainingLiveData.value
        if (currentList == null) {
            trainingLiveData.postValue(listOf(training))
        }
        else {
            val updatedList = currentList.toMutableList()
            updatedList.add(training)
            trainingLiveData.postValue(updatedList)
        }
    }
}

