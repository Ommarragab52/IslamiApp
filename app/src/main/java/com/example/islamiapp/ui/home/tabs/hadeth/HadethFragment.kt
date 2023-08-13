package com.example.islamiapp.ui.home.tabs.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.R
import com.example.islamiapp.ui.home.CONSTANTS
import java.io.InputStream

class HadethFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HadethNameAdapter
    lateinit var ahadethList: MutableList<Hadeth>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.hadeth_recyclerView)
        adapter = HadethNameAdapter(null)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        initData()
        onHadethClick()
    }

    private fun onHadethClick() {
        adapter.onItemClick =
            HadethNameAdapter.OnItemClick { position, hadeth ->
            var i= Intent(context,HadethDetailsActivity::class.java)
                i.putExtra(CONSTANTS.HADETH_CONTENT_KEY, hadeth.hadethContent.toTypedArray())
                startActivity(i)
            }
    }

    private fun initData() {
        ahadethList = mutableListOf()
        val inputStream: InputStream = requireContext().assets.open("ahadeth.txt")
        val text = inputStream.bufferedReader().use { it.readText() }
        val hadethList = text.trim().split("#")

        hadethList.forEach {
            var hadethName = it.trim().split("\n")
            ahadethList.add(Hadeth(hadethName[0], listOf(it)))
        }
        adapter.dataUpdate(ahadethList)
    }


}