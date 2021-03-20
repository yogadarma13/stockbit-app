package com.yogadarma.core.data.source.remote

import android.content.Context
import com.yogadarma.core.R
import com.yogadarma.core.data.source.remote.network.ApiResponse
import com.yogadarma.core.data.source.remote.network.ApiService
import com.yogadarma.core.data.source.remote.response.DataItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService, private val context: Context) {

    suspend fun getAllCrypto(limit: Int, tsym: String): Flow<ApiResponse<List<DataItem>>> {
        return flow {
            try {
                val response = apiService.getAllCrypto(limit, tsym)
                val listCrypto = response.data!!

                if (listCrypto.isNotEmpty()) {
                    emit(ApiResponse.Success(listCrypto))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(context.resources.getString(R.string.error_get_all_crypto_message)))
            }
        }.flowOn(Dispatchers.IO)
    }
}