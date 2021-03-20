package com.yogadarma.stockbitapp.di

import com.yogadarma.core.domain.usecase.GetCryptoInteractor
import com.yogadarma.core.domain.usecase.GetCryptoUseCase
import com.yogadarma.stockbitapp.presentation.watchlist.WatchlistViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    single<GetCryptoUseCase> { GetCryptoInteractor(get()) }
}

val viewModelModule = module {
    viewModel { WatchlistViewModel(get()) }
}