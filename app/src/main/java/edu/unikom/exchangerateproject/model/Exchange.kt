package edu.unikom.exchangerateproject.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Exchange(
    val country: String,
    val buy: String,
    val sell: String,
    val flag: Int
): Parcelable
