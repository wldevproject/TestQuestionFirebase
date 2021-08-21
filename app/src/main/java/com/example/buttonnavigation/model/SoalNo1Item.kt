package com.example.buttonnavigation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SoalNo1Item(
	val bobot: Double = 0.0,
	val soal: String = "null",
	val pilihan_jawaban: ArrayList<PilihanJawabanItem?>? = null,
	val no_soal: Int? = null
) : Parcelable