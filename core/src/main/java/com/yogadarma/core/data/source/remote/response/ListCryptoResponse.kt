package com.yogadarma.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListCryptoResponse(

    @field:SerializedName("Data")
    val data: List<DataItem>? = null

)

data class CoinInfo(

    @field:SerializedName("Name")
    val name: String? = null,

    @field:SerializedName("FullName")
    val fullName: String? = null,

    @field:SerializedName("Id")
    val id: String? = null

)

data class Usd(

    @field:SerializedName("IMAGEURL")
    val imageUrl: String? = null,

    @field:SerializedName("PRICE")
    val price: String? = null,

    @field:SerializedName("CHANGEPCT24HOUR")
    val changePct24Hour: String? = null

)

data class Display(

    @field:SerializedName("USD")
    val usd: Usd? = null
)

data class DataItem(

    @field:SerializedName("DISPLAY")
    val display: Display? = null,

    @field:SerializedName("CoinInfo")
    val coinInfo: CoinInfo? = null
)
