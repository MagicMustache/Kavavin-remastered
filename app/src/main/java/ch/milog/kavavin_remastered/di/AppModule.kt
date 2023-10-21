package ch.milog.kavavin_remastered.di

import ch.milog.kavavin_remastered.data.repository.BottleRepositoryImpl
import ch.milog.kavavin_remastered.domain.repository.BottleRepository
import ch.milog.kavavin_remastered.domain.useCases.AddBottle
import ch.milog.kavavin_remastered.domain.useCases.AddBottleUseCases
import ch.milog.kavavin_remastered.domain.useCases.CellarUseCases
import ch.milog.kavavin_remastered.domain.useCases.DeleteBottle
import ch.milog.kavavin_remastered.domain.useCases.GetBottles
import ch.milog.kavavin_remastered.domain.useCases.UpdateBottle
import ch.milog.kavavin_remastered.presentation.add_bottle.AddBottleViewModel
import ch.milog.kavavin_remastered.presentation.cellar.CellarViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<BottleRepository> { BottleRepositoryImpl() }
    single { GetBottles(get()) }
    single { UpdateBottle(get()) }
    single { DeleteBottle(get()) }
    single { AddBottle(get()) }
    single { CellarUseCases(get(), get(), get(), get()) }
    viewModel { CellarViewModel(get()) }
    single { AddBottleUseCases(get()) }
    single { AddBottleViewModel(get()) }
}