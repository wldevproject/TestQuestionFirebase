package com.example.buttonnavigation.modelv1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Soal(var pilihan: String, var point: String) : Parcelable