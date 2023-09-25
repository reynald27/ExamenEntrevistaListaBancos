package com.example.listabancos.data.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listabancos.R
import com.example.listabancos.data.model.BankModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class BankAdapter (private val list: List<BankModel>): RecyclerView.Adapter<BankAdapter.ViewHolder>(){
    class ViewHolder (view: View): RecyclerView.ViewHolder(view){
        @SuppressLint("SetTextI18n")
        fun bindItems(data: BankModel){
            val textViewBankName: TextView = itemView.findViewById(R.id.textViewBankName)
            val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription)
            val textViewAge: TextView = itemView.findViewById(R.id.textViewAge)
            val imageViewBankLogo: ImageView = itemView.findViewById(R.id.imageViewBankLogo)

            //Get data of Model
            val dataBankName = data.bankName
            val dataDescription = data.description
            val dataAge = data.age
            val dataUrl = data.url

            //Set info in view
            textViewBankName.text = dataBankName
            textViewAge.text = "($dataAge Años de antiguedad)"
            textViewDescription.text = dataDescription
            Glide.with(itemView.context).load(dataUrl).transform(CenterCrop(),
                RoundedCorners(40)
            ) .into(imageViewBankLogo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_bank, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}