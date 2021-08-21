package com.example.buttonnavigation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SoalNo2Item(
	val bobot: Double = 0.0,
	val soal: String = "null",
	val pilihan_jawaban: List<PilihanJawabanItem?>? = null,
	val no_soal: Int? = null
) : Parcelable