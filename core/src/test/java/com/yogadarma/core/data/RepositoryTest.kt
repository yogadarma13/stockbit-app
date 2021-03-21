package com.yogadarma.core.data

import com.yogadarma.core.data.source.local.LocalDataSource
import com.yogadarma.core.data.source.local.entity.CryptoEntity
import com.yogadarma.core.data.source.remote.RemoteDataSource
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
class RepositoryTest {

    private lateinit var repository: IRepository

    @Mock
    private lateinit var remoteDataSource: RemoteDataSource

    @Mock
    private lateinit var localDataSource: LocalDataSource

    @Before
    fun setUp() {
        repository = AppRepository(remoteDataSource, localDataSource)

        val dummyData: Flow<List<CryptoEntity>> =
            flow { emit(DataDummy.genereateDummyCryptoEntities()) }

        `when`(localDataSource.getAllCrypto()).thenReturn(dummyData)
    }

    @Test
    fun `should get data from source`() {
        repository.getAllCrypto(3, "USD")

        verify(localDataSource).getAllCrypto()
        verifyNoInteractions(localDataSource)
    }
}