package ch.milog.kavavin_remastered.domain.use_cases

import ch.milog.kavavin_remastered.domain.model.Bottle
import ch.milog.kavavin_remastered.domain.repository.BottleRepository
import ch.milog.kavavin_remastered.domain.utils.CellarOrder
import ch.milog.kavavin_remastered.domain.utils.OrderType

class GetBottles(private val bottleRepository: BottleRepository) {
    suspend operator fun invoke(cellarOrder: CellarOrder = CellarOrder.Quantity(OrderType.Descending)): List<Bottle> {
        if (cellarOrder.orderType == OrderType.Descending) {
            return bottleRepository.getBottles().sortedWith(compareByDescending {
                when (cellarOrder) {
                    is CellarOrder.Quantity -> it.quantity
                    is CellarOrder.Name -> it.name
                    is CellarOrder.Year -> it.year
                }
            })
        } else {
            return bottleRepository.getBottles().sortedWith(compareBy {
                when (cellarOrder) {
                    is CellarOrder.Quantity -> it.quantity
                    is CellarOrder.Name -> it.name
                    is CellarOrder.Year -> it.year
                }
            })
        }
    }
}