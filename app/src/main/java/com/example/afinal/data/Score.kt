package com.example.afinal.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// Entidad para la tabla "scores"
@Entity(tableName = "scores")

class Score {
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // ID único para cada puntuación
    val playerName: String, // Nombre del jugador
    val score: Int,         // Puntuación obtenida
    val date: Long          // Fecha de la puntuación (en milisegundos)
}