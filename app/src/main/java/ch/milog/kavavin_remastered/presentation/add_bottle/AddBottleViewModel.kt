package ch.milog.kavavin_remastered.presentation.add_bottle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ch.milog.kavavin_remastered.domain.model.Bottle
import ch.milog.kavavin_remastered.domain.use_cases.AddBottleUseCases

class AddBottleViewModel(private val addBottleUseCases: AddBottleUseCases) : ViewModel() {

    var name by mutableStateOf<String?>(null)
    var type by mutableStateOf<Long?>(null)
    var country by mutableStateOf<String?>(null)
    var region by mutableStateOf<String?>(null)
    var grape by mutableStateOf<String?>(null)
    var producer by mutableStateOf<String?>(null)
    var price by mutableStateOf<Long?>(null)
    var year by mutableStateOf<Long?>(null)
    var quantity by mutableStateOf<Long?>(null)

    fun onAdd(event: AddBottleEvent): Boolean {
        when (event) {
            is AddBottleEvent.AddBottle -> {
                if (name == null || type == null || quantity == null) {
                    return false
                } else {
                    addBottleUseCases.addBottle(
                        Bottle(
                            name = name!!,
                            type = type!!,
                            country = country,
                            region = region,
                            grape = grape,
                            producer = producer,
                            price = price,
                            year = year,
                            quantity = quantity!!,
                        )
                    )
                    return true
                }
            }
        }
    }
}