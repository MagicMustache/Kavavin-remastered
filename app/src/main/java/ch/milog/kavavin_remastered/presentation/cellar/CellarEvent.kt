package ch.milog.kavavin_remastered.presentation.cellar

import ch.milog.kavavin_remastered.domain.model.Bottle
import ch.milog.kavavin_remastered.domain.utils.CellarOrder

sealed class CellarEvent {
    data class OrderChanged(val order: CellarOrder) : CellarEvent()
    data class BottleDeleted(val bottle: Bottle) : CellarEvent()
    data class BottleUpdated(val bottle: Bottle) : CellarEvent()
}
