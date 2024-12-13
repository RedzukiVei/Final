package com.example.afinal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.afinal.databinding.ItemScoreBinding
import com.example.afinal.data.Score


class ScoreAdapter : ListAdapter<Score, ScoreAdapter.ScoreViewHolder>(ScoreDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        // Inflamos el diseño del ítem (item_score.xml) y lo pasamos al ViewHolder
        val binding = ItemScoreBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ScoreViewHolder(binding)
    }

    // Enlaza los datos con el ViewHolder para mostrar el ítem correspondiente
    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        val score = getItem(position)   // Obtiene el ítem actual de la lista
        holder.bind(score)  // Llama al método bind para configurar los datos en la vista
    }

    // ViewHolder que gestiona las vistas individuales de cada ítem
    class ScoreViewHolder(private val binding: ItemScoreBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // Método para enlazar los datos de un Score con las vistas del ítem
        fun bind(score: Score) {
            binding.tvPlayerName.text = score.playerName    // Nombre del jugador
            binding.tvPlayerScore.text = score.score.toString() // Puntuación del jugador
        }
    }

    // DiffUtil para optimizar la actualización de la lista

    class ScoreDiffCallback : DiffUtil.ItemCallback<Score>() {

        // Comprueba si dos ítems tienen el mismo ID (para identificar cambios en los datos)

        override fun areItemsTheSame(oldItem: Score, newItem: Score): Boolean {
            return oldItem.id == newItem.id
        }


        // Comprueba si dos ítems tienen el mismo contenido (para evitar actualizaciones innecesarias)

        override fun areContentsTheSame(oldItem: Score, newItem: Score): Boolean {
            return oldItem == newItem
        }
    }

}