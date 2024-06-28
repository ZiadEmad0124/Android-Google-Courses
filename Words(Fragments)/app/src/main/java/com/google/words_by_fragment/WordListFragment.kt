package com.google.words_by_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.words_by_fragment.adapter.WordsAdapter
import com.google.words_by_fragment.databinding.FragmentWordListBinding
import com.google.words_by_fragment.dataset.DataSet

class WordListFragment : Fragment() {

    private var _binding: FragmentWordListBinding? = null
    private val binding get() = _binding!!

    private val argument: WordListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWordListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val words: List<String> = DataSet.words.filter {
            it.startsWith(argument.letter, ignoreCase = true)
        }

        binding.recyclerView.adapter = WordsAdapter(requireContext(), words)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}