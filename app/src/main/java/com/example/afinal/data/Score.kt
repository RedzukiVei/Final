package com.example.afinal.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// Entidad para la tabla "scores"

@Entity(tableName = "scores")

data class Score(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val playerName: String,
    val score: Int,
    val date: Long
)