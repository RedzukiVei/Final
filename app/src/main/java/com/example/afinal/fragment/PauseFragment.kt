package com.example.afinal.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.afinal.R
import com.example.afinal.databinding.FragmentPauseBinding

class PauseFragment : Fragment() {

    private var _binding: FragmentPauseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflamos el diseño del fragmento
        _binding = FragmentPauseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Botón para reanudar el juego
        binding.btnResume.setOnClickListener {
            findNavController().navigateUp() // Regresa al GameFragment
        }

        // Botón para salir al menú principal
        binding.btnExit.setOnClickListener {
            findNavController().navigate(R.id.action_pauseFragment_to_startFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Limpia el binding para evitar memory leaks
        _binding = null
    }

}