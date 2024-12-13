package com.example.afinal.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.afinal.databinding.FragmentScoresBinding
import com.example.afinal.viewmodel.ScoresViewModel
import com.example.afinal.adapter.ScoreAdapter


class ScoresFragment : Fragment() {

    private var _binding: FragmentScoresBinding? = null
    private val binding get() = _binding!!

    private lateinit var scoresViewModel: ScoresViewModel
    private lateinit var scoreAdapter: ScoreAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflamos el diseño del fragmento
        _binding = FragmentScoresBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configuración del ViewModel
        scoresViewModel = ViewModelProvider(this)[ScoresViewModel::class.java]

        // Configuración del RecyclerView
        scoreAdapter = ScoreAdapter()
        binding.rvScores.layoutManager = LinearLayoutManager(requireContext())
        binding.rvScores.adapter = scoreAdapter

        // Observar los datos de las puntuaciones
        scoresViewModel.allScores.observe(viewLifecycleOwner) { scores ->
            scoreAdapter.submitList(scores) // Actualizamos la lista
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Limpia el binding para evitar memory leaks
        _binding = null
    }

}