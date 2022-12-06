package ch.milog.kavavin_remastered.presentation.cellar

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ch.milog.kavavin_remastered.domain.use_cases.CellarUseCases
import ch.milog.kavavin_remastered.domain.utils.CellarOrder
import ch.milog.kavavin_remastered.domain.utils.OrderType
import kotlinx.coroutines.launch

class CellarViewModel(private val cellarUseCases: CellarUseCases) : ViewModel() {

    private val _state = mutableStateOf(CellarState())
    val state: State<CellarState> = _state

    init {
        getBottles(CellarOrder.Quantity(OrderType.Descending))
    }

    fun onEvent(event: CellarEvent) {
        when (event) {
            is CellarEvent.OrderChanged -> {
                if (state.value.cellarOrder::class == event.order::class && state.value.cellarOrder.orderType == event.order.orderType) {
                    return
                }
                getBottles(event.order)
            }
            is CellarEvent.BottleUpdated -> {
                cellarUseCases.updateBottle(event.bottle)
            }
            is CellarEvent.BottleDeleted -> {
                cellarUseCases.deleteBottle(event.bottle)
            }
            is CellarEvent.Refresh -> {
                getBottles(event.order)
            }
            is CellarEvent.FilteredBottles -> {
                getBottles(event.order, event.filter)
            }
        }
    }

    private fun getBottles(cellarOrder: CellarOrder, filter: Long? = null) {
        viewModelScope.launch {
            val bottles = cellarUseCases.getBottles(cellarOrder, filter)
            _state.value = CellarState(
                bottles,
                cellarOrder,
            )
        }
    }
}
