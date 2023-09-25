package com.example.listabancos.data.network

import com.example.listabancos.core.RetrofitHelper
import com.example.listabancos.data.model.BankModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BankService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getBanks():List<BankModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(BanksApiClient::class.java).getAllBanks()
            response.body()?: emptyList()
        }
    }
}