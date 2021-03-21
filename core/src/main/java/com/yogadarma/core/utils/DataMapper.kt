package com.yogadarma.core.utils

import com.yogadarma.core.data.source.local.entity.CryptoEntity
import com.yogadarma.core.data.source.remote.response.DataItem
import com.yogadarma.core.domain.model.Crypto

object DataMapper {

    fun mapCryptoResponseToEntities(
        input: List<DataItem>
    ): List<CryptoEntity> {
        val cryptoList = ArrayList<CryptoEntity>()
        input.map {
            val crypto = CryptoEntity(
                it.coinInfo?.id.toString(),
                it.coinInfo?.name.toString(),
                it.coinInfo?.fullName.toString(),
                it.display?.usd?.price.toString(),
                it.display?.usd?.changePct24Hour.toString(),
                it.display?.usd?.imageUrl.toString()
            )
            cryptoList.add(crypto)
        }
        return cryptoList
    }

    fun mapEntitiesToDomain(input: List<CryptoEntity>): List<Crypto> =
        input.map {
            Crypto(
                it.id,
                it.name,
                it.fullName,
                it.price,
                it.percentage,
                it.imageUrl
            )
        }
}