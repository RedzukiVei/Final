package com.example.afinal.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ScoreDao {

    // Insertar una puntuación
    @Insert
    suspend fun insert(score: Score)

    // Obtener todas las puntuaciones en vivo
    @Query("SELECT * FROM scores ORDER BY score DESC")
    fun getAllScoresLive(): LiveData<List<Score>>

    // Eliminar todas las puntuaciones
    @Query("DELETE FROM scores")
    suspend fun deleteAll(): Int // Sin retorno o retorna int para filas eliminadas
}
