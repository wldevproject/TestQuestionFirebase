package com.example.buttonnavigation.modelv1.soal

import android.os.Parcelable
import com.example.buttonnavigation.modelv1.Soal
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Soalnya(var textSoal: String, var soal: ArrayList<Soal>) : Parcelable