package com.example.afinal.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.afinal.R
import com.example.afinal.databinding.FragmentStartBinding

// Fragment para la pantalla inicial del juego

class StartFragment : Fragment() {

    // Uso de View Binding para interactuar con las vistas

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{

        // Inflamos el diseño del fragmento usando el archivo de binding

        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        // Configurar el botón para iniciar el juego
        binding.btnStartGame.setOnClickListener {
            // Navegar al GameFragment
            findNavController().navigate(R.id.action_startFragment_to_gameFragment)
        }

        // Configurar el botón para ver puntuaciones
        binding.btnScores.setOnClickListener {
            // Navegar al ScoresFragment
            findNavController().navigate(R.id.action_startFragment_to_scoresFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Limpia el binding para evitar memory leaks
        _binding = null
    }
}