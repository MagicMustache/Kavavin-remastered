package ch.milog.kavavin_remastered.domain.utils

sealed class CellarOrder(val orderType: OrderType) {
    class Name(orderType: OrderType) : CellarOrder(orderType)
    class Year(orderType: OrderType) : CellarOrder(orderType)
    class Quantity(orderType: OrderType) : CellarOrder(orderType)


    private fun copy(orderType: OrderType): CellarOrder {
        return when (this) {
            is Name -> Name(orderType)
            is Year -> Year(orderType)
            is Quantity -> Quantity(orderType)
        }
    }

    companion object {
        fun compareAndReverse(oldOrder: CellarOrder, newOrder: CellarOrder, oldType: OrderType): CellarOrder {
            when (oldOrder) {
                is Name -> {
                    if (newOrder is Name) {
                        return newOrder.copy(orderType = oldType.reverseType())
                    }
                }

                is Year -> {
                    if (newOrder is Year) {
                        return newOrder.copy(orderType = oldType.reverseType())
                    }
                }

                is Quantity -> {
                    if (newOrder is Quantity) {
                        return newOrder.copy(orderType = oldType.reverseType())
                    }
                }
            }
            return newOrder
        }
    }
}
