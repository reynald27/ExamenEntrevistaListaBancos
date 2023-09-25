package com.example.listabancos.data.network

import com.example.listabancos.data.model.BankModel
import retrofit2.Response
import retrofit2.http.GET

interface BanksApiClient {
    @GET("catom/api/challenge/banks")
    suspend fun getAllBanks():Response<List<BankModel>>
}