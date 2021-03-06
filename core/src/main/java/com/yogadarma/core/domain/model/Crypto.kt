package com.yogadarma.core.domain.model

data class Crypto(
    val id: String,
    val name: String,
    val fullName: String,
    val price: String,
    val percentage: String,
    val imageUrl: String
)