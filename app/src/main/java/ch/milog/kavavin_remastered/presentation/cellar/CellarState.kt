package ch.milog.kavavin_remastered.presentation.cellar

import ch.milog.kavavin_remastered.domain.model.Bottle
import ch.milog.kavavin_remastered.domain.utils.CellarOrder
import ch.milog.kavavin_remastered.domain.utils.OrderType

data class CellarState(
    val bottles: List<Bottle> = emptyList(),
    val cellarOrder: CellarOrder = CellarOrder.Quantity(OrderType.Descending),
)
