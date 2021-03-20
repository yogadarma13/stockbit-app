package com.yogadarma.stockbitapp.presentation.watchlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.yogadarma.core.domain.usecase.GetCryptoUseCase

class WatchlistViewModel(private val getCryptoUseCase: GetCryptoUseCase) : ViewModel() {

    fun getAllCrypto(limit: Int, tsym: String) =
        getCryptoUseCase.getAllCrypto(limit, tsym).asLiveData()
}