package com.example.afinal.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.afinal.R
import com.example.afinal.databinding.FragmentGameBinding
import com.example.afinal.viewmodel.GameViewModel

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private val gameViewModel: GameViewModel by viewModels() // Vincular el ViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        // Inflamos el diseño del fragmento

        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observadores para actualizar la UI
        gameViewModel.score.observe(viewLifecycleOwner) { score ->
            binding.tvScore.text = "Puntuación: $score"
        }


        gameViewModel.missedObjects.observe(viewLifecycleOwner) { missed ->
            binding.tvMissed.text = "Fallos: $missed"
            if (missed >= 5) {
                gameViewModel.stopGame()
                findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment)
            }
        }

        gameViewModel.isGameRunning.observe(viewLifecycleOwner) { isRunning ->
            if (!isRunning) stopGameLoop()
        }


        //Botón de pausa
        binding.btnPause.setOnClickListener {
            isGameRunning = false
            findNavController().navigate(R.id.action_gameFragment_to_pauseFragment)
        }

        startGameLoop()
    }

    //Método para iniciar el juego

    private fun startGameLoop(){
        //Manejamos la lógica del juego en un bucle
        val handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            override fun run(){
                if(gameViewModel.isGameRunning.value == true) {
                    gameViewModel.incrementScore() // Incrementa la puntuación
                    if ((1..10).random() > 8) { // Simular fallo
                        gameViewModel.incrementMissedObjects()
                    }
                    handler.postDelayed(this, 1000) //Repetimos cada segundo
                }
            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}