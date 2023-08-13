package com.example.islamiapp.ui.home.tabs.quran

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.R
import java.io.InputStream

class SuraDetailsActivity : AppCompatActivity() {
    private var SuraDetailsName: TextView? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SuraDetailsAdapter
    private lateinit var itemsList: List<String>
    private var backImage: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        SuraDetailsName = findViewById(R.id.sura_details_name)
        recyclerView = findViewById(R.id.sura_details_recyclerView)
        backImage = findViewById(R.id.back_image)
        backImage?.setOnClickListener {
            finish()
        }
        adapter = SuraDetailsAdapter(null)
        recyclerView.adapter = adapter
        SuraDetailsName?.text = intent.getStringExtra("SURA_NAME")
        getSuraDetails()

    }

    private fun getSuraDetails() {
        itemsList = ArrayList()
        val index = intent.getIntExtra("SURA_NUMBER", 0)
        val inputStream: InputStream = assets.open("${index + 1}.txt")
        val text = inputStream.bufferedReader().use { it.readText() }
        val itemList = text.trim().split("\n")
        adapter.updateData(itemList)
    }
}