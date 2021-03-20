package com.yogadarma.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "crypto")
data class CryptoEntity(
    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "fullName")
    val fullName: String,

    @ColumnInfo(name = "price")
    val price: String,

    @ColumnInfo(name = "percentage")
    val percentage: String,

    @ColumnInfo(name = "imageUrl")
    val imageUrl: String
)