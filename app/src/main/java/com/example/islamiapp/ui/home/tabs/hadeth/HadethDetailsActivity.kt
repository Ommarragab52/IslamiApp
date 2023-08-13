package com.example.islamiapp.ui.home.tabs.hadeth

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.R
import com.example.islamiapp.ui.home.CONSTANTS
import com.example.islamiapp.ui.home.tabs.quran.SuraDetailsAdapter

class HadethDetailsActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SuraDetailsAdapter
    private lateinit var ahadethList: List<String>
    private var backImage: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        backImage = findViewById(R.id.back_image)
        backImage?.setOnClickListener {
            finish()
        }

        recyclerView = findViewById(R.id.sura_details_recyclerView)
        adapter = SuraDetailsAdapter(null)
        recyclerView.adapter = adapter
        initData()
    }

    private fun initData() {
        ahadethList =
            intent.getStringArrayExtra(CONSTANTS.HADETH_CONTENT_KEY)?.toList() ?: listOf("")
        adapter.updateData(ahadethList)
    }
}