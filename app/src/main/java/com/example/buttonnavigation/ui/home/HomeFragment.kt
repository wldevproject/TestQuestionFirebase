package com.example.buttonnavigation.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.buttonnavigation.modelv1.soalnew.SoalnyaNew
import com.example.buttonnavigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })

        homeViewModel.semuaSoal.observe(viewLifecycleOwner, { data ->
            onSoalSemua(data)
        })
        return root
    }

    private fun onSoalSemua(data: List<SoalnyaNew>) {
        val list = ArrayList<String>()
        for (aData in data) {
            list.add(aData.textSoal)
        }
        Log.d("->>>> Soalnya", list.toString())
        Log.d("->>>> test", data.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}