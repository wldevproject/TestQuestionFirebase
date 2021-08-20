package com.example.buttonnavigation.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.buttonnavigation.*
import com.example.buttonnavigation.databinding.FragmentDashboardBinding
import com.example.buttonnavigation.modelv1.soal.DataSoal
import com.example.buttonnavigation.modelv1.Soal
import com.example.buttonnavigation.modelv1.soal.Soalnya
import kotlin.math.pow
import kotlin.math.roundToInt


class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.judulHalaman
        dashboardViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })

//        dashboardViewModel.noSatu.observe(viewLifecycleOwner, { data ->
//            onSoalNoSatu(data)
//        })
//
//        dashboardViewModel.noDua.observe(viewLifecycleOwner, { data ->
//            onSoalNoDua(data)
//        })
//
//        dashboardViewModel.noTiga.observe(viewLifecycleOwner, { data ->
//            onSoalNoTiga(data)
//        })
        dashboardViewModel.semuaSoal.observe(viewLifecycleOwner, { data ->
            val list = ArrayList<String>()
            for (aData in data) {
                list.add(aData.textSoal)
            }

//            onSoalSemua(data)
            onSoalNoSatu(data[0])
        })

        return root
    }

    private fun onSoalSemua(data: ArrayList<Soalnya>?) {
        Log.d("->>>> Dashboard Frament", data.toString())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnHasil.setOnClickListener {
            if (ConsData.nilaiSatu == 0 || ConsData.nilaiDua == 0 || ConsData.nilaiTiga == 0) {
                Toast.makeText(
                    requireContext(),
                    "${DataSoal.test}\n" +
                            "Data Belum Diisi",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val max = DataSoal.test.maxOrNull() ?: 0
                val nilaiA = ConsData.nilaiSatu.toDouble() / max.toDouble()
                val nilaiB = ConsData.nilaiDua.toDouble() / max.toDouble()
                val nilaiC = ConsData.nilaiTiga.toDouble() / max.toDouble()

                val angkaSignifikan = 2
                val temp = 10.0.pow(angkaSignifikan.toDouble())
                val result1 = (((50.0 / 100.0) * nilaiA) * temp).roundToInt().toDouble() / temp
                val result2 = (((40.0 / 100.0) * nilaiB) * temp).roundToInt().toDouble() / temp
                val result3 = (((10.0 / 100.0) * nilaiC) * temp).roundToInt().toDouble() / temp
                val fResult = ((result1 + result2 + result3) * temp).roundToInt().toDouble() / temp

                Toast.makeText(
                    requireContext(),
                    "${DataSoal.test}\n" +
                            "nilai max $max\n" +
                            "$nilaiA, $nilaiB, $nilaiC\n" +
                            "$result1, $result2, $result3\n" +
                            "Hasil nilai adalah $fResult",
                    Toast.LENGTH_SHORT
                ).show()

                val text = if (fResult > 0.5) {
                    "Kamu Mendapatkan Bantuan"
                } else {
                    "Kamu Tidak Mendapatkan Bantuan"
                }
                binding.textResult.text = text
            }
        }
    }

    private fun onSoalNoSatu(data: Soalnya) {

        val list = ArrayList<String>()
        for (aData in data.soal) {
            list.add(aData.pilihan)
        }

        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, list)
        (binding.textFieldOne.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        (binding.textFieldOne.editText as? AutoCompleteTextView)?.onItemClickListener =
            AdapterView.OnItemClickListener { parent, _, pos, _ ->
                ConsData.pilihanSatu = parent.getItemAtPosition(pos).toString()
                ConsData.nilaiSatu = (data.soal[pos].point).toInt()

                DataSoal.test[0] = ConsData.nilaiSatu
            }
    }

    private fun onSoalNoDua(data: ArrayList<Soal>) {
        val list = ArrayList<String>()
        for (aData in data) {
            list.add(aData.pilihan)
        }

        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, list)
        (binding.textFieldTwo.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        (binding.textFieldTwo.editText as? AutoCompleteTextView)?.onItemClickListener =
            AdapterView.OnItemClickListener { parent, _, pos, _ ->
                ConsData.pilihanDua = parent.getItemAtPosition(pos).toString()
                ConsData.nilaiDua = (data[pos].point).toInt()

                DataSoal.test[1] = ConsData.nilaiDua
            }
    }

    private fun onSoalNoTiga(data: ArrayList<Soal>) {
        val list = ArrayList<String>()
        for (aData in data) {
            list.add(aData.pilihan)
        }

        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, list)
        (binding.textFieldTree.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        (binding.textFieldTree.editText as? AutoCompleteTextView)?.onItemClickListener =
            AdapterView.OnItemClickListener { parent, _, pos, _ ->
                ConsData.pilihanTiga = parent.getItemAtPosition(pos).toString()
                ConsData.nilaiTiga = (data[pos].point).toInt()

                DataSoal.test[2] = ConsData.nilaiTiga
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}