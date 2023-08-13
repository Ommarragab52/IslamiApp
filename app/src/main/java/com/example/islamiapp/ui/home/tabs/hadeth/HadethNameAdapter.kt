package com.example.islamiapp.ui.home.tabs.hadeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamiapp.R

class HadethNameAdapter(var ahadethList: List<Hadeth>? = null) :
    RecyclerView.Adapter<HadethNameAdapter.HadethNameViewHolder>() {

    class HadethNameViewHolder(v: View) : ViewHolder(v) {
        var hadethName: TextView = v.findViewById(R.id.hadeth_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethNameViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val v = layoutInflater.inflate(R.layout.item_hadeth_name, parent, false)
        return HadethNameViewHolder(v)
    }

    fun dataUpdate(ahadethList: List<Hadeth>?) {
        this.ahadethList = ahadethList
        notifyDataSetChanged()
    }

    var onItemClick: OnItemClick? = null
    override fun onBindViewHolder(holder: HadethNameViewHolder, position: Int) {
        val item: Hadeth = ahadethList?.get(position) ?: Hadeth("null", listOf("null"))
        holder.hadethName.text = item.hadethName
        holder.itemView.setOnClickListener {
            onItemClick?.onHadethClick(position, item)
        }
    }

    override fun getItemCount(): Int {
        return ahadethList?.size ?: 0
    }

    fun interface OnItemClick {
        fun onHadethClick(position: Int, hadeth: Hadeth)
    }


}