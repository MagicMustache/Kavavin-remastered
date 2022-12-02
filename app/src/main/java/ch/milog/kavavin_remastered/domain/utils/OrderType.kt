package ch.milog.kavavin_remastered.domain.utils

sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}


