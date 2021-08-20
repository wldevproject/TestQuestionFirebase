package com.example.buttonnavigation.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buttonnavigation.modelv1.soal.DataSoal
import com.example.buttonnavigation.modelv1.Soal
import com.example.buttonnavigation.modelv1.soal.Soalnya

class DashboardViewModel : ViewModel() {

//    private val _noSatu = MutableLiveData<ArrayList<Soal>>().apply {
//        value = DataSoal.soalNoSatu
//    }
//    val noSatu: LiveData<ArrayList<Soal>> = _noSatu
//
//    private val _noDua = MutableLiveData<ArrayList<Soal>>().apply {
//        value = DataSoal.soalNoDua
//    }
//    val noDua: LiveData<ArrayList<Soal>> = _noDua
//
//    private val _noTiga = MutableLiveData<ArrayList<Soal>>().apply {
//        value = DataSoal.soalNoTiga
//    }
//    val noTiga: LiveData<ArrayList<Soal>> = _noTiga

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    private val _semuaSoal = MutableLiveData<ArrayList<Soalnya>>().apply {
        value = DataSoal.soalSemua
    }
    val semuaSoal: LiveData<ArrayList<Soalnya>> = _semuaSoal
}