package ch.milog.kavavin_remastered.domain.useCases

data class CellarUseCases(
    val getBottles: GetBottles,
    val updateBottle: UpdateBottle,
    val deleteBottle: DeleteBottle,
    val addBottle: AddBottle
)
