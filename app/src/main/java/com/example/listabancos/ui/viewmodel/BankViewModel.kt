package com.example.listabancos.ui.viewmodel

import android.preference.PreferenceManager
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listabancos.data.model.BankModel
import com.example.listabancos.domain.GetBanksUseCase
import kotlinx.coroutines.launch
import org.json.JSONObject

class BankViewModel: ViewModel() {
    val banksModel = MutableLiveData<List<BankModel>?>()
    val isLoading = MutableLiveData<Boolean>()
    var getBanksUseCase = GetBanksUseCase()

    fun banksList(){
        viewModelScope.launch{
           isLoading.postValue(true)
           var banks: List<BankModel>? = getBanksUseCase()
           if(!banks.isNullOrEmpty()){
               banksModel.postValue(banks)
               isLoading.postValue(false)
           }else{
               isLoading.postValue(true)
           }
        }
    }

}