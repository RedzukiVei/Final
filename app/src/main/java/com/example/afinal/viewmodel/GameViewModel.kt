package com.example.afinal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    // Puntuación actual del jugador
    private val _score = MutableLiveData(0)
    val score: LiveData<Int> get() = _score

    // Objetos fallados
    private val _missedObjects = MutableLiveData(0)
    val missedObjects: LiveData<Int> get() = _missedObjects

    // Estado del juego
    private val _isGameRunning = MutableLiveData(true)
    val isGameRunning: LiveData<Boolean> get() = _isGameRunning

    // Incrementar puntuación
    fun incrementScore() {
        _score.value = (_score.value ?: 0) + 1
    }

    // Incrementar fallos
    fun incrementMissedObjects() {
        _missedObjects.value = (_missedObjects.value ?: 0) + 1
    }

    // Detener el juego
    fun stopGame() {
        _isGameRunning.value = false
    }

    // Reiniciar el juego
    fun resetGame() {
        _score.value = 0
        _missedObjects.value = 0
        _isGameRunning.value = true
    }
}