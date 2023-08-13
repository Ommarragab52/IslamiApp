package com.example.islamiapp.ui.home.tabs.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamiapp.R

class SuraDetailsAdapter(var itemsList: List<String>? = null) :
    Adapter<SuraDetailsAdapter.SuraDetailsViewHolder>() {

    class SuraDetailsViewHolder(itemView: View) : ViewHolder(itemView) {
        var suraTextView: TextView = itemView.findViewById(R.id.sura_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraDetailsViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_details, parent, false)
        return SuraDetailsViewHolder(v)
    }
    fun updateData(itemsList:List<String>){
        this.itemsList = itemsList
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return itemsList?.size ?: 0
    }

    override fun onBindViewHolder(holder: SuraDetailsViewHolder, position: Int) {
        holder.suraTextView.text = itemsList?.get(position)
    }
}