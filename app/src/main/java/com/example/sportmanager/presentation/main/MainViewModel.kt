package com.example.sportmanager.presentation.main

import androidx.lifecycle.ViewModel
import com.example.sportmanager.domain.models.trainings.SaveTrainingParam
import com.example.sportmanager.domain.models.trainings.TrainingList
import com.example.sportmanager.domain.usecase.NewTrainingUseCase

class MainViewModel(
    val trainingList: TrainingList,
    private val newTrainingUseCase: NewTrainingUseCase,
) : ViewModel() {

    var trainingLive = trainingList.getList()

    init {

    }

    fun save(trainingName: String) {
        val param = SaveTrainingParam(trainingName)
        newTrainingUseCase.execute(param)
    }
}