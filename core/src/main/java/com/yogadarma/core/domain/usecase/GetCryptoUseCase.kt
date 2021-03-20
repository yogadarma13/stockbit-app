package com.yogadarma.core.domain.usecase

import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Crypto
import kotlinx.coroutines.flow.Flow

interface GetCryptoUseCase {
    fun getAllCrypto(limit: Int, tsym: String): Flow<Resource<List<Crypto>>>
}