package ch.milog.kavavin_remastered.data.repository

import android.util.Log
import ch.milog.kavavin_remastered.domain.model.Bottle
import ch.milog.kavavin_remastered.domain.repository.BottleRepository
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlin.coroutines.suspendCoroutine

class BottleRepositoryImpl : BottleRepository {

    private val db = Firebase.firestore
    private val currentUser = Firebase.auth.currentUser

    override suspend fun getBottles(filter: Long?): List<Bottle> {
        return suspendCoroutine {
            var bottles = mutableListOf<Bottle>()
            if (currentUser != null) {
                db.collection("bottles")
                    .whereEqualTo("userId", currentUser.uid)
                    .get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            if (document.data.isNotEmpty()) {
                                val bottle = document.data
                                if (bottle["quantity"] as Long != 0L) {
                                    bottles.add(
                                        Bottle(
                                            document.id,
                                            bottle["type"] as Long,
                                            bottle["name"] as String,
                                            bottle["country"] as String?,
                                            bottle["region"] as String?,
                                            bottle["year"] as Long?,
                                            bottle["grape"] as String?,
                                            bottle["price"] as Long?,
                                            bottle["producer"] as String?,
                                            bottle["quantity"] as Long,
                                            bottle["userId"] as String
                                        )
                                    )
                                }
                            }
                        }
                        if (filter != null) {
                            bottles = bottles.filter {
                                it.type == filter
                            }.toMutableList()
                        }
                        it.resumeWith(Result.success(bottles))
                    }
                    .addOnFailureListener { exception ->
                        it.resumeWith(Result.success(bottles))
                        Log.e("FIREBASE", "Error getting documents: $exception")
                    }
            }
        }
    }

    override fun updateBottle(bottle: Bottle) {
        TODO("Not yet implemented")
    }

    override fun insertBottle(bottle: Bottle) {
        TODO("Not yet implemented")
    }

    override fun deleteBottle(bottle: Bottle) {
        TODO("Not yet implemented")
    }


}