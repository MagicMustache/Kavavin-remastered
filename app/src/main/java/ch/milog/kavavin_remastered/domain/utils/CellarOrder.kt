package ch.milog.kavavin_remastered.domain.utils

sealed class CellarOrder(val orderType: OrderType) {
    class Name(orderType: OrderType) : CellarOrder(orderType)
    class Year(orderType: OrderType) : CellarOrder(orderType)
    class Quantity(orderType: OrderType) : CellarOrder(orderType)

    fun copy(orderType: OrderType): CellarOrder {
        return when (this) {
            is Name -> Name(orderType)
            is Year -> Year(orderType)
            is Quantity -> Quantity(orderType)
        }
    }
}
