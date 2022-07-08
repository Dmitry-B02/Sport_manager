package com.example.sportmanager.presentation.trainingdetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sportmanager.data.repository.ExerciseRepImpl
import com.example.sportmanager.domain.models.exercises.ExerciseList
import com.example.sportmanager.domain.usecase.AddExerciseUseCase

class TrainingDetailViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val exerciseList = ExerciseList()
    private val exerciseRepository by lazy { ExerciseRepImpl(exerciseList) }
    private val addExerciseUseCase by lazy { AddExerciseUseCase(exerciseRepository) }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TrainingDetailViewModel(exerciseList, addExerciseUseCase) as T
    }
}