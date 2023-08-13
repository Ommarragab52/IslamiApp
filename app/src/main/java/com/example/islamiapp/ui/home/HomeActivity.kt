package com.example.islamiapp.ui.home

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.islamiapp.R
import com.example.islamiapp.ui.home.tabs.hadeth.HadethFragment
import com.example.islamiapp.ui.home.tabs.quran.QuranFragment
import com.example.islamiapp.ui.home.tabs.radio.RadioFragment
import com.example.islamiapp.ui.home.tabs.sebha.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var themeMode: ImageButton
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViews()
        setTabFragment()
        changeAppTheme()

    }

    private fun changeAppTheme() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            themeMode.setImageResource(R.drawable.ic_light_mode)
        else themeMode.setImageResource(R.drawable.ic_dark_mode)
        themeMode.setOnClickListener {
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                themeMode.setImageResource(R.drawable.ic_light_mode)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                themeMode.setImageResource(R.drawable.ic_dark_mode)
            }
        }
    }

    private fun initViews() {
        bottomNavigationView = findViewById(R.id.bottom_navigation_bar)
        themeMode = findViewById(R.id.theme_mode)
    }

    private fun replaceTabFragment(fragment: Fragment) {
        val fragmentManger = supportFragmentManager
        val fragmentTransaction = fragmentManger.beginTransaction()
        fragmentTransaction
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun setTabFragment() {
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.quran_item -> {
                    replaceTabFragment(QuranFragment())
                }

                R.id.hadeth_item -> {
                    replaceTabFragment(HadethFragment())
                }

                R.id.sebha_item -> {
                    replaceTabFragment(SebhaFragment())
                }

                R.id.radio_item -> {
                    replaceTabFragment(RadioFragment())
                }

            }
            true
        }
        bottomNavigationView.selectedItemId = R.id.quran_item
    }


}