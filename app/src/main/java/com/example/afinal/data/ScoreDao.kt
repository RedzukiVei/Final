package com.example.afinal.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

// DAO para realizar operaciones en la tabla "scores"
@Dao

class ScoreDao {
    // Insertar una nueva puntuación
    @Insert
    suspend fun insert(score: Score)

    // Obtener todas las puntuaciones ordenadas por mayor puntuación
    @Query("SELECT * FROM scores ORDER BY score DESC")
    fun getAllScoresLive(): LiveData<List<Score>>

    // Eliminar todas las puntuaciones
    @Query("DELETE FROM scores")
    suspend fun deleteAll()
}