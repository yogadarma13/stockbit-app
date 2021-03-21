package com.yogadarma.core.domain.usecase

import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Crypto
import com.yogadarma.core.domain.repository.IRepository
import com.yogadarma.core.utils.DataDummy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetCryptoUseCaseTest {

    private lateinit var getCryptoUseCase: GetCryptoUseCase

    @Mock
    private lateinit var repository: IRepository

    @Before
    fun setUp() {
        getCryptoUseCase = GetCryptoInteractor(repository)

        val dummyData: Flow<Resource<List<Crypto>>> =
            flow { emit(Resource.Success(DataDummy.genereateDummyCrypto())) }

        `when`(repository.getAllCrypto(3, "USD")).thenReturn(dummyData)
    }


    @Test
    fun `should get data from repository`() {
        getCryptoUseCase.getAllCrypto(3, "USD")

        verify(repository).getAllCrypto(3, "USD")
        verifyNoMoreInteractions(repository)
    }
}