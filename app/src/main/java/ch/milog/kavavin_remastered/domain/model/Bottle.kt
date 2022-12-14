package ch.milog.kavavin_remastered.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Bottle(
    val id: String? = null,
    val type: Long,
    val name: String,
    val country: String? = null,
    val region: String? = null,
    val year: Long? = null,
    val grape: String? = null,
    val price: Long? = null,
    val producer: String? = null,
    var quantity: Long,
    var userId: String? = null,
) : Parcelable