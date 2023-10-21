package ch.milog.kavavin_remastered.presentation.add_bottle

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ch.milog.kavavin_remastered.domain.model.Bottle
import ch.milog.kavavin_remastered.domain.useCases.AddBottleUseCases

class AddBottleViewModel(private val addBottleUseCases: AddBottleUseCases) : ViewModel() {

    private val _name = mutableStateOf(
        AddBottleState(
            hint = "Name"
        )
    )
    val name: State<AddBottleState> = _name

    private val _year = mutableStateOf(
        AddBottleState(
            hint = "Year"
        )
    )
    val year: State<AddBottleState> = _year

    private val _country = mutableStateOf(
        AddBottleState(
            hint = "Country"
        )
    )
    val country: State<AddBottleState> = _country

    private val _region = mutableStateOf(
        AddBottleState(
            hint = "Region"
        )
    )
    val region: State<AddBottleState> = _region

    private val _grapes = mutableStateOf(
        AddBottleState(
            hint = "Grapes"
        )
    )
    val grapes: State<AddBottleState> = _grapes

    private val _producer = mutableStateOf(
        AddBottleState(
            hint = "Producer"
        )
    )
    val producer: State<AddBottleState> = _producer

    private val _type = mutableStateOf(
        AddBottleState(
            hint = "Type"
        )
    )
    val type: State<AddBottleState> = _type

    private val _quantity = mutableStateOf(
        AddBottleState(
            hint = "Quantity"
        )
    )
    val quantity: State<AddBottleState> = _quantity

    private val _price = mutableStateOf(
        AddBottleState(
            hint = "Price"
        )
    )
    val price: State<AddBottleState> = _price

    fun onEvent(event: AddBottleEvent) {
        when (event) {
            is AddBottleEvent.AddBottle -> {
                if (name.value.text == null || type.value.text == null || quantity.value.text == null) {
                    return
                } else {
                    addBottleUseCases.addBottle(
                        Bottle(
                            name = name.value.text!!,
                            type = type.value.text!!.toLong(),
                            country = country.value.text,
                            region = region.value.text,
                            grape = grapes.value.text,
                            producer = producer.value.text,
                            price = price.value.text?.toLong(),
                            year = year.value.text?.toLong(),
                            quantity = quantity.value.text!!.toLong(),
                        )
                    )
                }
            }

            is AddBottleEvent.NameChanged -> {
                _name.value = _name.value.copy(text = event.name)
            }

            is AddBottleEvent.YearChanged -> {
                _year.value = _year.value.copy(text = event.year)
            }

            is AddBottleEvent.CountryChanged -> {
                _country.value = _country.value.copy(text = event.country)
            }

            is AddBottleEvent.RegionChanged -> {
                _region.value = _region.value.copy(text = event.region)
            }

            is AddBottleEvent.GrapesChanged -> {
                _grapes.value = _grapes.value.copy(text = event.grapes)
            }

            is AddBottleEvent.ProducerChanged -> {
                _producer.value = _producer.value.copy(text = event.producer)
            }

            is AddBottleEvent.TypeChanged -> {
                _type.value = _type.value.copy(text = event.type)
            }

            is AddBottleEvent.QuantityChanged -> {
                _quantity.value = _quantity.value.copy(text = event.quantity)
            }

            is AddBottleEvent.PriceChanged -> {
                _price.value = _price.value.copy(text = event.price)
            }
        }
    }
}