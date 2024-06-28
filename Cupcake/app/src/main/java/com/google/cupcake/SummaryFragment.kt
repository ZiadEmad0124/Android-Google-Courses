package com.google.cupcake

import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.cupcake.databinding.FragmentSummaryBinding

class SummaryFragment : Fragment() {

    private var _binding: FragmentSummaryBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSummaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            summaryViewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
            sendButton.setOnClickListener { sendOrder() }
            cancelButton.setOnClickListener { cancelOrder() }
        }
    }

    private fun sendOrder() {
        val orderSummary = getString(
            R.string.order_details,
            sharedViewModel.quantity.value.toString(),
            sharedViewModel.flavor.value.toString(),
            sharedViewModel.date.value.toString(),
            sharedViewModel.price.value.toString()
        )

        val intent = Intent(ACTION_SEND)
            .setType("text/plan")
            .putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_details))
            .putExtra(Intent.EXTRA_SUBJECT, orderSummary)

        startActivity(intent)
    }

    private fun cancelOrder() {
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_summaryFragment_to_startFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}