package ch.milog.kavavin_remastered.di

import ch.milog.kavavin_remastered.data.repository.BottleRepositoryImpl
import ch.milog.kavavin_remastered.domain.repository.BottleRepository
import ch.milog.kavavin_remastered.domain.use_cases.*
import ch.milog.kavavin_remastered.presentation.add_bottle.AddBottleViewModel
import ch.milog.kavavin_remastered.presentation.cellar.CellarViewModel
import org.koin.dsl.module

val appModule = module {
    single<BottleRepository> { BottleRepositoryImpl() }
    single { GetBottles(get()) }
    single { UpdateBottle(get()) }
    single { DeleteBottle(get()) }
    single { AddBottle(get()) }
    single { CellarUseCases(get(), get(), get(), get()) }
    single { CellarViewModel(get()) }
    single { AddBottleUseCases(get()) }
    single { AddBottleViewModel(get()) }
}