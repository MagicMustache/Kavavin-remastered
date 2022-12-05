package ch.milog.kavavin_remastered.domain.repository

import ch.milog.kavavin_remastered.domain.model.Bottle

interface BottleRepository {
    suspend fun getBottles(filter: Long? = null): List<Bottle>
    fun insertBottle(bottle: Bottle)
    fun deleteBottle(bottle: Bottle)
    fun updateBottle(bottle: Bottle)
}