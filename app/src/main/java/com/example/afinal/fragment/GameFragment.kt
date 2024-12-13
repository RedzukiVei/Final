package com.example.afinal.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.afinal.R
import com.example.afinal.databinding.FragmentGameBinding

class GameFragment : Fragment {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    //variables del juego

    private var score = 0 // puntuación inicial
    private var missedObjects = 0 // Objetos no recogidos
    private var isGameRunning = true // Estado del juego

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        // Inflamos el diseño del fragmento

        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Configuración inicial del juego
        startGame()

        //Botón de pausa
        binding.btnPause.setOnClickListener {
            isGameRunning = false
            findNavController().navigate(R.id.action_gameFragment_to_pauseFragment)
        }
    }

    //Método para iniciar el juego

    private fun startGame(){
        //Manejamos la lógica del juego en un bucle
        val handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            override fun run(){
                if(isGameRunning) {
                    updateGame() //Actualizamos el estado de juego
                    handler.postDelayed(this, 1000) //Repetimos cada segundo
                }
            }
        })
    }

    //Actualizamos el estado del juego


}