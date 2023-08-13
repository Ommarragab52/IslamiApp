package com.example.islamiapp.ui.home.tabs.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamiapp.R

class QuranItemsAdapter(private var itemsList: List<String>) :
    Adapter<QuranItemsAdapter.QuranItemsViewHolder>() {
    class QuranItemsViewHolder(itemView: View) : ViewHolder(itemView) {
        var suraName: TextView = itemView.findViewById(R.id.sura_name)
        var suraNumber: TextView = itemView.findViewById(R.id.sura_number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranItemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sura_name, parent, false)
        return QuranItemsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    var onItemClickListener: OnItemClickListener? = null
    override fun onBindViewHolder(holder: QuranItemsViewHolder, position: Int) {
        holder.suraName.text = itemsList[position]
        holder.suraNumber.text = position.plus(1).toString()
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(position, itemsList[position])
        }
    }

    fun interface OnItemClickListener {
        fun onItemClick(position: Int, name: String)
    }
}