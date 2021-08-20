package com.example.buttonnavigation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
	val soalNo2: List<SoalNo2Item?>? = null,
	val soalNo3: List<SoalNo3Item?>? = null,
	val soalNo1: List<SoalNo1Item?>? = null
) : Parcelable