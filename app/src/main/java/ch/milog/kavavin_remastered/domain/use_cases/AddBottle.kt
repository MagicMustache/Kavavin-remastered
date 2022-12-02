package ch.milog.kavavin_remastered.domain.use_cases

import ch.milog.kavavin_remastered.domain.model.Bottle
import ch.milog.kavavin_remastered.domain.repository.BottleRepository

class AddBottle(private val bottleRepository: BottleRepository) {
    operator fun invoke(bottle: Bottle) {
        bottleRepository.insertBottle(bottle)
    }
}