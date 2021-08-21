package com.example.buttonnavigation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.buttonnavigation.ConsData
import com.example.buttonnavigation.R
import com.example.buttonnavigation.databinding.ItemTextfieldBinding
import com.example.buttonnavigation.model.SoalNo1Item


/**
 ** Written by CND_Studio 16/03/2021 22.29.
 ** Author @JoeFachrizal
 ** Happy Code...
 **/
class ListSoal1Adapter(private var listSoal: ArrayList<SoalNo1Item>) :
    RecyclerView.Adapter<ListSoal1Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSoal1Adapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = ItemTextfieldBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListSoal1Adapter.ViewHolder, position: Int) {
        holder.bind(listSoal[position])
    }

    override fun getItemCount(): Int = listSoal.size

    inner class ViewHolder(var binding: ItemTextfieldBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(dataItem: SoalNo1Item) {
            binding.apply {
                soal.text = dataItem.soal

                val list = ArrayList<String>()
                dataItem.pilihan_jawaban?.forEach { aData ->
                    aData?.pilihan?.let { list.add(it) }
                }

                val adapter = ArrayAdapter(itemView.context, R.layout.list_item, list)
                (binding.textField.editText as? AutoCompleteTextView)?.setAdapter(adapter)

                (binding.textField.editText as? AutoCompleteTextView)?.onItemClickListener =
                    AdapterView.OnItemClickListener { parent, _, pos, _ ->
                        ConsData.pilihan[dataItem.no_soal?.minus(1) ?: 0] = parent.getItemAtPosition(pos).toString()
                        ConsData.nilai[dataItem.no_soal?.minus(1) ?: 0] = dataItem.pilihan_jawaban?.get(pos)?.point?.toInt() ?: 0
                        Toast.makeText(itemView.context, "${ConsData.pilihan} ->> ${ConsData.nilai}", Toast.LENGTH_SHORT)
                            .show()
                    }
            }
        }
    }

    init {
        notifyDataSetChanged()
    }

}