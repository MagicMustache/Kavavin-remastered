package ch.milog.kavavin_remastered.domain.use_cases

import ch.milog.kavavin_remastered.domain.model.Bottle
import ch.milog.kavavin_remastered.domain.repository.BottleRepository

class UpdateBottle(private val bottleRepository: BottleRepository) {
    operator fun invoke(bottle: Bottle) {
        bottleRepository.updateBottle(bottle)
    }
}