package com.yogadarma.core.data.source.local

import com.yogadarma.core.data.source.local.entity.CryptoEntity
import com.yogadarma.core.data.source.local.room.AppDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val appDao: AppDao) {

    fun getAllCrypto(): Flow<List<CryptoEntity>> = appDao.getAllCrypto()

    suspend fun insertCryptoData(cryptoList: List<CryptoEntity>) =
        appDao.insertCryptoData(cryptoList)
}