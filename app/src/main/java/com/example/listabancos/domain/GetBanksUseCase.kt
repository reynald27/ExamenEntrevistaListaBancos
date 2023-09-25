package com.example.listabancos.domain

import com.example.listabancos.data.BankRepository
import com.example.listabancos.data.model.BankModel

class GetBanksUseCase {
    private val repository = BankRepository()
    suspend operator fun invoke(): List<BankModel>? = repository.getBanksAll()
}