package com.example.listabancos.data

import com.example.listabancos.data.model.BankModel
import com.example.listabancos.data.model.BankProvider
import com.example.listabancos.data.network.BankService

class BankRepository {
    private val api = BankService()

    suspend fun getBanksAll():List<BankModel>{
        val response: List<BankModel> = api.getBanks()
        BankProvider.banks = response
        return response
    }
}