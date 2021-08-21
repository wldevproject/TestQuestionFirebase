package com.example.buttonnavigation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buttonnavigation.modelv1.DataSoal
import com.example.buttonnavigation.modelv1.Soal

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _semuaSoal = MutableLiveData<List<Soal>>().apply {
        value = DataSoal.soalSemua
    }
    val semuaSoal: LiveData<List<Soal>> = _semuaSoal

}