package com.example.buttonnavigation.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.buttonnavigation.ConsData
import com.example.buttonnavigation.adapter.ListSoal1Adapter
import com.example.buttonnavigation.databinding.FragmentDashboardBinding
import com.example.buttonnavigation.model.SoalNo1Item
import kotlin.math.pow
import kotlin.math.roundToInt


class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ListSoal1Adapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        dashboardViewModel.text.observe(viewLifecycleOwner, {
            initData(it)
        })

        ConsData.pilihan.clear()
        ConsData.nilai.clear()
        return root
    }

    private fun initData(arrayList: ArrayList<SoalNo1Item>) {
        binding.apply {
            rvListSoal.scheduleLayoutAnimation()
            rvListSoal.setHasFixedSize(true)
            ViewCompat.setNestedScrollingEnabled(rvListSoal, true)
        }

        adapter = ListSoal1Adapter(arrayList)
        binding.rvListSoal.adapter = adapter

        for (data in arrayList) {
            ConsData.pilihan.add("")
            ConsData.nilai.add(0)
        }

        metodeHitung(arrayList)
    }

    private fun metodeHitung(list: ArrayList<SoalNo1Item>) {
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
                ConsData.fresult = (jumHasil * temp).roundToInt().toDouble() / temp

                Toast.makeText(
                    requireContext(),
                    "${ConsData.nilai}\n" +
                            "nilai max $max\n" +
                            "${stapNilai}\n" +
                            "${result}\n" +
                            "Hasil nilai adalah ${ConsData.fresult}",
                    Toast.LENGTH_SHORT
                ).show()

                val text = if (ConsData.fresult > 0.5) {
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