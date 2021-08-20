package com.example.buttonnavigation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SoalNo2Item(
	val bobot: Double? = null,
	val soal: String? = null,
	val pilihanJawaban: List<PilihanJawabanItem?>? = null,
	val noSoal: Int? = null
) : Parcelable