package com.example.listabancos.ui.view

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.GridLayout
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.listabancos.data.adapter.BankAdapter
import com.example.listabancos.data.model.BankModel
import com.example.listabancos.databinding.ActivityMainBinding
import com.example.listabancos.ui.viewmodel.BankViewModel
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : ComponentActivity() {
    private lateinit var binding : ActivityMainBinding
    private val bankViewModel: BankViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bankViewModel.banksList()
        bankViewModel.banksModel.observe(this) { banks ->
            binding.recyclerViewBanks.layoutManager = GridLayoutManager(applicationContext, 1)
            val adapter = BankAdapter(banks as List<BankModel>)
            binding.recyclerViewBanks.adapter = adapter
        }

        bankViewModel.isLoading.observe(this) {
            binding.progressBarDataLoading.isVisible = it
        }
    }
}