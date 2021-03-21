package com.yogadarma.stockbitapp.watchlist

import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Crypto
import com.yogadarma.core.domain.usecase.GetCryptoUseCase
import com.yogadarma.core.utils.DataDummy
import com.yogadarma.stockbitapp.presentation.watchlist.WatchlistViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class WatchlistViewModelTest {

    private lateinit var watchlistViewModel: WatchlistViewModel

    @Mock
    private lateinit var getCryptoUseCase: GetCryptoUseCase

    @Before
    fun setUp() {
        watchlistViewModel = WatchlistViewModel(getCryptoUseCase)

        val dummyData: Flow<Resource<List<Crypto>>> =
            flow { emit(Resource.Success(DataDummy.genereateDummyCrypto())) }

        `when`(getCryptoUseCase.getAllCrypto(3, "USD")).thenReturn(dummyData)
    }

    @Test
    fun `should get data from usecase`() {
        watchlistViewModel.getAllCrypto(3, "USD")

        verify(getCryptoUseCase).getAllCrypto(3, "USD")
        verifyNoMoreInteractions(getCryptoUseCase)
    }
}