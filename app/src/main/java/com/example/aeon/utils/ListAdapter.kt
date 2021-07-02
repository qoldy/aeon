package com.example.aeon.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aeon.R
import com.example.aeon.data.Payment

class ListAdapter(val payments:ArrayList<Payment>):RecyclerView.Adapter<ListAdapter.Holder>() {
    class Holder(item:View):RecyclerView.ViewHolder(item){
        var descTextView:TextView?=null
        var amountTextView:TextView?=null
        var currTextView:TextView?=null
        var createdTextView:TextView?=null
        init{
            descTextView=item.findViewById(R.id.description)
            amountTextView=item.findViewById(R.id.amount)
            currTextView=item.findViewById(R.id.currency)
            createdTextView=item.findViewById(R.id.created)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val item = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        return Holder(item)
    }

    override fun getItemCount(): Int { return payments.size }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.descTextView?.text=payments[position].description
        holder.amountTextView?.text="Количество: " + payments[position].amount.toString()
        holder.currTextView?.text="Валюта: " + payments[position].currency
        holder.createdTextView?.text="Создано: "+ payments[position].created
    }
}