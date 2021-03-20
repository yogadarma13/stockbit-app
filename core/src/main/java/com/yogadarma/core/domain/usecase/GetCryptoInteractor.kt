package com.yogadarma.core.domain.usecase

import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Crypto
import com.yogadarma.core.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow

class GetCryptoInteractor(private val repository: IRepository) : GetCryptoUseCase {
    override fun getAllCrypto(limit: Int, tsym: String): Flow<Resource<List<Crypto>>> =
        repository.getAllCrypto(limit, tsym)
}