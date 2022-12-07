package ch.milog.kavavin_remastered.presentation.add_bottle

sealed class AddBottleEvent {
    object AddBottle : AddBottleEvent()
    data class NameChanged(val name: String) : AddBottleEvent()
    data class YearChanged(val year: String) : AddBottleEvent()
    data class CountryChanged(val country: String) : AddBottleEvent()
    data class RegionChanged(val region: String) : AddBottleEvent()
    data class GrapesChanged(val grapes: String) : AddBottleEvent()
    data class ProducerChanged(val producer: String) : AddBottleEvent()
    data class TypeChanged(val type: String) : AddBottleEvent()
    data class QuantityChanged(val quantity: String) : AddBottleEvent()
    data class PriceChanged(val price: String) : AddBottleEvent()
}