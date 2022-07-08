package com.example.sportmanager.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sportmanager.R
import com.example.sportmanager.domain.models.trainings.Training
import com.example.sportmanager.domain.models.trainings.TrainingList

class TrainingAdapter(private val trainings: TrainingList, private val onClick: (Training) -> Unit) :
    ListAdapter<Training, TrainingAdapter.TrainingViewHolder>(TrainingDiffCallback) {

    class TrainingViewHolder(view: View, val onClick: (Training) -> Unit) : RecyclerView.ViewHolder(view) {
        val trainingTextView: TextView = view.findViewById(R.id.trainingTextView)
        var currentTraining: Training? = null

        init {
            view.setOnClickListener {
                currentTraining?.let {
                    onClick(it)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return trainings.getList().value?.size ?: 0
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrainingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.training_row_item, parent, false)
        return TrainingViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        holder.currentTraining = trainings.getList().value?.get(position)
        holder.trainingTextView.text = trainings.getList().value?.get(position)?.name?.name.toString()
    }

    object TrainingDiffCallback : DiffUtil.ItemCallback<Training>() {
        override fun areItemsTheSame(oldItem: Training, newItem: Training): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Training, newItem: Training): Boolean {
            return oldItem.id == newItem.id
        }

    }
}