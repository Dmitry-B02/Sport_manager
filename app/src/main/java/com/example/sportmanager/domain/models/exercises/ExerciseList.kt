package com.example.sportmanager.domain.models.exercises

import androidx.lifecycle.MutableLiveData

class ExerciseList {
    private val exerciseList: List<Exercise> = listOf()
    private val exerciseLiveData = MutableLiveData(exerciseList)

    fun getList(): MutableLiveData<List<Exercise>> {
        return exerciseLiveData
    }

    fun add(exercise: Exercise) {
        val currentList = exerciseLiveData.value
        if (currentList == null) {
            exerciseLiveData.postValue(listOf(exercise))
        }
        else {
            val updatedList = currentList.toMutableList()
            updatedList.add(exercise)
            exerciseLiveData.postValue(updatedList)
        }
    }

    fun replace(exerciseList: List<Exercise>) {
        exerciseLiveData.postValue(exerciseList)
    }
}