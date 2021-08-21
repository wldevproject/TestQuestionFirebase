package com.example.buttonnavigation.modelv1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Soal(var textSoal: String, var soal: Map<String, Int>) : Parcelable