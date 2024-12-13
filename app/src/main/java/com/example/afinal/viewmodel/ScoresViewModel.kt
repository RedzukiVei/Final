package com.example.afinal.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.afinal.data.AppDatabase
import com.example.afinal.data.Score
import com.example.afinal.data.ScoreDao
import kotlinx.coroutines.launch

class ScoresViewModel(application: Application) : AndroidViewModel(application) {

    private val scoreDao: ScoreDao = AppDatabase.getDatabase(application).scoreDao()

    // LiveData para observar las puntuaciones
    val allScores: LiveData<List<Score>> = scoreDao.getAllScoresLive()

    // Método para insertar una nueva puntuación
    fun insertScore(score: Score) {
        viewModelScope.launch {
            scoreDao.insert(score)
        }
    }

    // Método para eliminar todas las puntuaciones
    fun clearScores() {
        viewModelScope.launch {
            scoreDao.deleteAll()
        }
    }
}