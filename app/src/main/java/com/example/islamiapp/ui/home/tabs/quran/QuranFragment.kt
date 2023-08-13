package com.example.islamiapp.ui.home.tabs.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.R
import java.util.Locale

class QuranFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: QuranItemsAdapter
    lateinit var itemsList: List<String>
    private var locale:Locale?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.quran_recyclerView)
        initData()
        adapter = QuranItemsAdapter(itemsList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        onItemClick()
    }

    private fun onItemClick() {
        adapter.onItemClickListener =
            QuranItemsAdapter.OnItemClickListener { position, name ->
                val intent = Intent(context, SuraDetailsActivity::class.java)
                intent.putExtra("SURA_NAME", name)
                intent.putExtra("SURA_NUMBER", position)
                startActivity(intent)
            }
    }

    private var ArSuras = arrayOf(
        "الفاتحة",
        "البقرة",
        "آل عمران",
        "النساء",
        "المائدة",
        "الأنعام",
        "الأعراف",
        "الأنفال",
        "التوبة",
        "يونس",
        "هود",
        "يوسف",
        "الرعد",
        "إبراهيم",
        "الحجر",
        "النحل",
        "الإسراء",
        "الكهف",
        "مريم",
        "طه",
        "الأنبياء",
        "الحج",
        "المؤمنون",
        "النّور",
        "الفرقان",
        "الشعراء",
        "النّمل",
        "القصص",
        "العنكبوت",
        "الرّوم",
        "لقمان",
        "السجدة",
        "الأحزاب",
        "سبأ",
        "فاطر",
        "يس",
        "الصافات",
        "ص",
        "الزمر",
        "غافر",
        "فصّلت",
        "الشورى",
        "الزخرف",
        "الدّخان",
        "الجاثية",
        "الأحقاف",
        "محمد",
        "الفتح",
        "الحجرات",
        "ق",
        "الذاريات",
        "الطور",
        "النجم",
        "القمر",
        "الرحمن",
        "الواقعة",
        "الحديد",
        "المجادلة",
        "الحشر",
        "الممتحنة",
        "الصف",
        "الجمعة",
        "المنافقون",
        "التغابن",
        "الطلاق",
        "التحريم",
        "الملك",
        "القلم",
        "الحاقة",
        "المعارج",
        "نوح",
        "الجن",
        "المزّمّل",
        "المدّثر",
        "القيامة",
        "الإنسان",
        "المرسلات",
        "النبأ",
        "النازعات",
        "عبس",
        "التكوير",
        "الإنفطار",
        "المطفّفين",
        "الإنشقاق",
        "البروج",
        "الطارق",
        "الأعلى",
        "الغاشية",
        "الفجر",
        "البلد",
        "الشمس",
        "الليل",
        "الضحى",
        "الشرح",
        "التين",
        "العلق",
        "القدر",
        "البينة",
        "الزلزلة",
        "العاديات",
        "القارعة",
        "التكاثر",
        "العصر",
        "الهمزة",
        "الفيل",
        "قريش",
        "الماعون",
        "الكوثر",
        "الكافرون",
        "النصر",
        "المسد",
        "الإخلاص",
        "الفلق",
        "الناس"
    )
    private var EnSuras = arrayOf(
        "Al-Fatihah",
        "Al-Baqara",
        "Al-Imran",
        "An-Nisa",
        "Al-Ma'idah",
        "Al-An'am",
        "Al-A'raf",
        "Anfal",
        "Tawbah",
        "Younes",
        " Hood",
        " Joseph ",
        " Thunder ",
        " Abraham ",
        " Stone ",
        " Bee ",
        " Isra ",
        " The Cave ",
        " Maryam ",
        " Taha ",
        " Prophets ",
        " Hajj ",
        " Believers",
        " Light ",
        " Al-Furqan ",
        " Poets ",
        " Ants ",
        " Stories ",
        " Al-Ankabut ",
        " Rum ",
        " Luqman ",
        " Prostration ",
        " Al-Ahzab ",
        " Sheba ",
        " Fatir ",
        " Yassin ",
        " Al-Safat ",
        " Al-Zumar ",
        " Ghafer ",
        " Fussilat ",
        " Al-Shura ",
        " Al-Zukhruf ",
        " Al-Dukhan ",
        " Al-Jathiya ",
        " Al-Ahqaf",
        " Muhammad ",
        " Al-Fath ",
        " Al-Hujurat ",
        " Q ",
        " Al-Dhariyat ",
        " Al-Tur ",
        " Al-Najm ",
        " The Moon ",
        " Al-Rahman ",
        " Al-Waqah ",
        " Al-Hadid ",
        " Al-Mujadala ",
        " Hashr ",
        " Examined ",
        " Class ",
        " Friday ",
        " Hypocrites ",
        " Al-Taghabun ",
        " Divorce ",
        " Prohibition ",
        " King ",
        " Pen ",
        " Al-Haqa ",
        " Al-Maarij ",
        " Noah ",
        " Jinn ",
        " Muzammil ",
        " Muddaththir ",
        " Resurrection ",
        " Human ",
        " Mursalat ",
        " Al-Naba ",
        " Al-Nazi`at ",
        " Abs ",
        " At-Takwir ",
        " Iftar",
        " Al-Mutafafeen ",
        " Al-Inshiqaq ",
        " Al-Buruj ",
        " Al-Tariq ",
        " The Most High ",
        " Al-Ghashiya ",
        " Al-Fajr ",
        " Al-Balad ",
        " Al-Shams ",
        " The Night ",
        " Al-Duha ",
        " Al-Sharh ",
        " figs ",
        " leeches ",
        " fate ",
        " evidence ",
        " earthquake ",
        " ordinary ",
        " Al-Qara ",
        " reproduction ",
        " era ",
        "Al-Hamza",
        "The Elephant",
        "Quraysh",
        "Al-Ma’un",
        "Al-Kawthar",
        "The Unbelievers",
        "An-Nasr",
        "Al-Masd",
        "Al-Ikhlas",
        "Al-Falq",
        "An-Nas"
    )

    private fun initData() {
        itemsList = if (Locale.getDefault().language=="ar")
            ArSuras.asList()
        else EnSuras.asList()
    }


}