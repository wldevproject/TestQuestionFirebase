package com.example.buttonnavigation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PilihanJawabanItem(
	val pilihan: String? = null,
	val point: String? = null
) : Parcelable