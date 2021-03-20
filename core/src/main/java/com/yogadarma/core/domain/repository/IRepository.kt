package com.yogadarma.core.domain.repository

import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Crypto
import kotlinx.coroutines.flow.Flow

interface IRepository {

    fun getAllCrypto(limit: Int, tsym: String): Flow<Resource<List<Crypto>>>
}