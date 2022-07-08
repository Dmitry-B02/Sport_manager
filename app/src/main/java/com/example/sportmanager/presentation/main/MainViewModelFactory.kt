package com.example.sportmanager.presentation.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sportmanager.data.repository.TrainingRepImpl
import com.example.sportmanager.data.storage.SharedPrefTrainingStorage
import com.example.sportmanager.domain.models.trainings.TrainingList
import com.example.sportmanager.domain.usecase.NewTrainingUseCase

class MainViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val trainingList = TrainingList()
    private val sharedPrefTrainingStorage by lazy { SharedPrefTrainingStorage() }
    private val trainingRepository by lazy { TrainingRepImpl(trainingList, sharedPrefTrainingStorage) }
    private val newTrainingUseCase by lazy { NewTrainingUseCase(trainingRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(trainingList, newTrainingUseCase) as T
    }
}