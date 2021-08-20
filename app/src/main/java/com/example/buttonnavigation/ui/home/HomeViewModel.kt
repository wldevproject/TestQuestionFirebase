package com.example.buttonnavigation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buttonnavigation.modelv1.soalnew.DataSoalNew
import com.example.buttonnavigation.modelv1.soalnew.SoalnyaNew

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _semuaSoal = MutableLiveData<List<SoalnyaNew>>().apply {
        value = DataSoalNew.soalSemua
    }
    val semuaSoal: LiveData<List<SoalnyaNew>> = _semuaSoal

}