package com.yogadarma.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListCryptoResponse(

	@field:SerializedName("RateLimit")
	val rateLimit: RateLimit? = null,

	@field:SerializedName("Type")
	val type: Int? = null,

	@field:SerializedName("Message")
	val message: String? = null,

	@field:SerializedName("MetaData")
	val metaData: MetaData? = null,

	@field:SerializedName("HasWarning")
	val hasWarning: Boolean? = null,

	@field:SerializedName("Data")
	val data: List<DataItem>? = null,

	@field:SerializedName("SponsoredData")
	val sponsoredData: List<Any?>? = null
)

data class CoinInfo(

	@field:SerializedName("Internal")
	val internal: String? = null,

	@field:SerializedName("Rating")
	val rating: Rating? = null,

	@field:SerializedName("BlockTime")
	val blockTime: Double? = null,

	@field:SerializedName("ImageUrl")
	val imageUrl: String? = null,

	@field:SerializedName("MaxSupply")
	val maxSupply: Double? = null,

	@field:SerializedName("DocumentType")
	val documentType: String? = null,

	@field:SerializedName("Algorithm")
	val algorithm: String? = null,

	@field:SerializedName("Url")
	val url: String? = null,

	@field:SerializedName("Name")
	val name: String? = null,

	@field:SerializedName("Type")
	val type: Int? = null,

	@field:SerializedName("ProofType")
	val proofType: String? = null,

	@field:SerializedName("NetHashesPerSecond")
	val netHashesPerSecond: String? = null,

	@field:SerializedName("AssetLaunchDate")
	val assetLaunchDate: String? = null,

	@field:SerializedName("FullName")
	val fullName: String? = null,

	@field:SerializedName("Id")
	val id: String? = null,

	@field:SerializedName("BlockNumber")
	val blockNumber: Int? = null,

	@field:SerializedName("BlockReward")
	val blockReward: Double? = null
)

data class Usd(

	@field:SerializedName("CONVERSIONTYPE")
	val conversionType: String? = null,

	@field:SerializedName("LASTTRADEID")
	val lastTradeId: String? = null,

	@field:SerializedName("OPEN24HOUR")
	val open24Hour: String? = null,

	@field:SerializedName("HIGHDAY")
	val highDay: String? = null,

	@field:SerializedName("LOW24HOUR")
	val low24Hour: String? = null,

	@field:SerializedName("TOPTIERVOLUME24HOUR")
	val topTierVolume24Hour: String? = null,

	@field:SerializedName("TOTALVOLUME24HTO")
	val totalVolume24HTo: String? = null,

	@field:SerializedName("TOSYMBOL")
	val toSymbol: String? = null,

	@field:SerializedName("LASTVOLUME")
	val lastVolume: String? = null,

	@field:SerializedName("LASTMARKET")
	val lastMarket: String? = null,

	@field:SerializedName("LOWHOUR")
	val lowHour: String? = null,

	@field:SerializedName("CONVERSIONSYMBOL")
	val conversionSymbol: String? = null,

	@field:SerializedName("MKTCAP")
	val mKtcap: String? = null,

	@field:SerializedName("LASTUPDATE")
	val lastUpdate: String? = null,

	@field:SerializedName("CHANGEPCTHOUR")
	val changePctHour: String? = null,

	@field:SerializedName("TOTALVOLUME24H")
	val totalVolume24H: String? = null,

	@field:SerializedName("VOLUMEHOURTO")
	val volumeHourTo: String? = null,

	@field:SerializedName("VOLUMEHOUR")
	val volumeHour: String? = null,

	@field:SerializedName("TOPTIERVOLUME24HOURTO")
	val topTierVolume24HourTo: String? = null,

	@field:SerializedName("CHANGEDAY")
	val changeDay: String? = null,

	@field:SerializedName("FLAGS")
	val flags: String? = null,

	@field:SerializedName("SUPPLY")
	val supply: String? = null,

	@field:SerializedName("TYPE")
	val type: String? = null,

	@field:SerializedName("IMAGEURL")
	val imageUrl: String? = null,

	@field:SerializedName("VOLUMEDAY")
	val volumeDay: String? = null,

	@field:SerializedName("VOLUME24HOUR")
	val voulem24Hour: String? = null,

	@field:SerializedName("MARKET")
	val market: String? = null,

	@field:SerializedName("PRICE")
	val price: String? = null,

	@field:SerializedName("CHANGEPCTDAY")
	val changePctDay: String? = null,

	@field:SerializedName("TOTALTOPTIERVOLUME24H")
	val totalTopTierVolumeH: String? = null,

	@field:SerializedName("FROMSYMBOL")
	val fromSymbol: String? = null,

	@field:SerializedName("LASTVOLUMETO")
	val lastVolumeTo: String? = null,

	@field:SerializedName("CHANGEPCT24HOUR")
	val changePct24Hour: String? = null,

	@field:SerializedName("OPENDAY")
	val openDay: String? = null,

	@field:SerializedName("TOTALTOPTIERVOLUME24HTO")
	val totalTopTierVolume24HTo: String? = null,

	@field:SerializedName("VOLUMEDAYTO")
	val volumeDayTo: String? = null,

	@field:SerializedName("OPENHOUR")
	val openHour: String? = null,

	@field:SerializedName("CHANGE24HOUR")
	val change24Hour: String? = null,

	@field:SerializedName("CHANGEHOUR")
	val changeHour: String? = null,

	@field:SerializedName("HIGH24HOUR")
	val high24Hour: String? = null,

	@field:SerializedName("VOLUME24HOURTO")
	val volume24HourTo: String? = null,

	@field:SerializedName("LOWDAY")
	val lowDay: String? = null,

	@field:SerializedName("HIGHHOUR")
	val highHour: String? = null,

	@field:SerializedName("MKTCAPPENALTY")
	val mKtcapPenalty: String? = null
)

data class MetaData(

	@field:SerializedName("Count")
	val count: Int? = null
)

data class Weiss(

	@field:SerializedName("Rating")
	val rating: String? = null,

	@field:SerializedName("TechnologyAdoptionRating")
	val technologyAdoptionRating: String? = null,

	@field:SerializedName("MarketPerformanceRating")
	val marketPerformanceRating: String? = null
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

data class RateLimit(
	val any: Any? = null
)

data class Rating(

	@field:SerializedName("Weiss")
	val weiss: Weiss? = null
)
