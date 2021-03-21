package com.yogadarma.core.utils

import com.yogadarma.core.data.source.local.entity.CryptoEntity
import com.yogadarma.core.data.source.remote.response.CoinInfo
import com.yogadarma.core.data.source.remote.response.DataItem
import com.yogadarma.core.data.source.remote.response.Display
import com.yogadarma.core.data.source.remote.response.Usd
import com.yogadarma.core.domain.model.Crypto

object DataDummy {
    fun genereateDummyCryptoEntities(): List<CryptoEntity> {

        val cryptoEntities = ArrayList<CryptoEntity>()

        cryptoEntities.add(
            CryptoEntity(
                "1",
                "BTC",
                "Bitcoin",
                "$ 2.00",
                "2%",
                "media/btn.png"
            )
        )

        cryptoEntities.add(
            CryptoEntity(
                "2",
                "ADA",
                "Cardano",
                "$ 1.00",
                "1.2%",
                "media/ada.png"
            )
        )

        cryptoEntities.add(
            CryptoEntity(
                "3",
                "ETH",
                "Ethereum",
                "$ 1.20",
                "0.5%",
                "media/eth.png"
            )
        )

        return cryptoEntities
    }

    fun generateResponseDummy(): List<DataItem> {

        val dataItem = ArrayList<DataItem>()

        dataItem.add(
            DataItem(
                Display(
                    Usd(
                        "media/btn.png",
                        "$ 2.00",
                        "2%"
                    )
                ),
                CoinInfo("BTC", "Bitcoin", "1")
            )
        )

        dataItem.add(
            DataItem(
                Display(
                    Usd(
                        "media/ada.png",
                        "$ 1.00",
                        "1.2%"
                    )
                ),
                CoinInfo("ADA", "Cardano", "2")
            )
        )

        dataItem.add(
            DataItem(
                Display(
                    Usd(
                        "media/eth.png",
                        "$ 1.20",
                        "0.5%"
                    )
                ),
                CoinInfo("ETH", "Ethereum", "3")
            )
        )

        return dataItem
    }

    fun genereateDummyCrypto(): List<Crypto> {

        val cryptoData = ArrayList<Crypto>()

        cryptoData.add(
            Crypto(
                "2",
                "ADA",
                "Cardano",
                "$ 1.00",
                "1.2%",
                "media/ada.png"
            )
        )

        cryptoData.add(
            Crypto(
                "2",
                "ADA",
                "Cardano",
                "$ 1.00",
                "1.2%",
                "media/ada.png"
            )
        )

        cryptoData.add(
            Crypto(
                "3",
                "ETH",
                "Ethereum",
                "$ 1.20",
                "0.5%",
                "media/eth.png"
            )
        )

        return cryptoData
    }
}