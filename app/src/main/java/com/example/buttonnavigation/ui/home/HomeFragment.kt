package com.example.buttonnavigation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.buttonnavigation.ConsData
import com.example.buttonnavigation.adapter.ListSoal3Adapter
import com.example.buttonnavigation.databinding.FragmentHomeBinding
import com.example.buttonnavigation.model.SoalNo3Item
import kotlin.math.pow
import kotlin.math.roundToInt

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ListSoal3Adapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.title.observe(viewLifecycleOwner,{
            binding.title.text = it
        })

        homeViewModel.text.observe(viewLifecycleOwner, {
            initData(it)
        })

        ConsData.pilihan.clear()
        ConsData.nilai.clear()
        return root
    }

    private fun initData(arrayList: ArrayList<SoalNo3Item>) {
        binding.apply {
            rvListSoal.scheduleLayoutAnimation()
            rvListSoal.setHasFixedSize(true)
            ViewCompat.setNestedScrollingEnabled(rvListSoal, true)
        }

        adapter = ListSoal3Adapter(arrayList)
        binding.rvListSoal.adapter = adapter

        for (data in arrayList) {
            ConsData.pilihan.add("")
            ConsData.nilai.add(0)
        }

        metodeHitung(arrayList)
    }

    private fun metodeHitung(list: ArrayList<SoalNo3Item>) {
        binding.btnHasil.setOnClickListener {
            if (ConsData.nilai.contains(0)) {
                Toast.makeText(
                    requireContext(),
                    "${ConsData.nilai}\n" +
                            "Data Belum Diisi",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val max = ConsData.nilai.maxOrNull() ?: 0
                val stapNilai: ArrayList<Double> = arrayListOf()
                ConsData.nilai.forEach { nilai ->
                    stapNilai.add(nilai.toDouble() / max.toDouble())
                }

                var jumHasil = 0.0
                val angkaSignifikan = 2
                val temp = 10.0.pow(angkaSignifikan.toDouble())
                val result: ArrayList<Double> = arrayListOf()
                stapNilai.forEachIndexed { index, d ->
                    val fHasil = (((list[index].bobot) * d) * temp).roundToInt().toDouble() / temp
                    result.add(fHasil)
                    jumHasil += fHasil
                }
                ConsData.fresult3 = (jumHasil * temp).roundToInt().toDouble() / temp

                Toast.makeText(
                    requireContext(),
                    "${ConsData.nilai}\n" +
                            "nilai max $max\n" +
                            "${stapNilai}\n" +
                            "${result}\n" +
                            "Hasil nilai adalah ${ConsData.fresult3}",
                    Toast.LENGTH_SHORT
                ).show()

                val text = if (ConsData.fresult3 > 0.5) {
                    "Kamu Mendapatkan Bantuan"
                } else {
                    "Kamu Tidak Mendapatkan Bantuan"
                }
                binding.textResult.text = text
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}