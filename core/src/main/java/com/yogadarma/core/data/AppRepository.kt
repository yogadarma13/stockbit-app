package com.yogadarma.core.data

import com.yogadarma.core.data.source.local.LocalDataSource
import com.yogadarma.core.data.source.remote.RemoteDataSource
import com.yogadarma.core.data.source.remote.network.ApiResponse
import com.yogadarma.core.data.source.remote.response.DataItem
import com.yogadarma.core.domain.model.Crypto
import com.yogadarma.core.domain.repository.IRepository
import com.yogadarma.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IRepository {
    override fun getAllCrypto(limit: Int, tsym: String): Flow<Resource<List<Crypto>>> =
        object : NetworkBoundResource<List<Crypto>, List<DataItem>>() {
            override fun loadFromDB(): Flow<List<Crypto>> {
                return localDataSource.getAllCrypto().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Crypto>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<DataItem>>> =
                remoteDataSource.getAllCrypto(limit, tsym)

            override suspend fun saveCallResult(data: List<DataItem>) {
                val cryptoList = DataMapper.mapCryptoResponseToEntities(data)

                localDataSource.insertCryptoData(cryptoList)
            }

        }.asFlow()
}