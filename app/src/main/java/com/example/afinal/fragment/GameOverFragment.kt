package com.example.afinal.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.afinal.R
import com.example.afinal.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {

    private var _binding: FragmentGameOverBinding? = null
    private val binding get() = _binding!!

    // Obtenemos los argumentos pasados desde el GameFragment
    private val args: GameOverFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflamos el diseño del fragmento
        _binding = FragmentGameOverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mostrar la puntuación final
        binding.tvFinalScore.text = "Puntuación final: ${args.finalScore}"

        // Botón para reiniciar el juego
        binding.btnRetry.setOnClickListener {
            findNavController().navigate(R.id.action_gameOverFragment_to_gameFragment)
        }

        // Botón para volver al menú principal
        binding.btnMainMenu.setOnClickListener {
            findNavController().navigate(R.id.action_gameOverFragment_to_startFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Limpia el binding para evitar memory leaks
        _binding = null
    }

}