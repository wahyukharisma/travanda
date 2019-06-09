package com.example.travanda

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v4.view.PagerAdapter
import kotlinx.android.synthetic.main.landing_scene.*

class OnLanding : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing_scene)
        val item1:ScreenItem= ScreenItem("text1","test2",R.drawable.ic_email_blue_24dp)
        val item2:ScreenItem=ScreenItem("text2","test2",R.drawable.ic_arrow_back_black_24dp)
        val item3:ScreenItem=ScreenItem("text3","test2",R.drawable.ic_mtrl_chip_checked_black)
        val items= listOf<ScreenItem>(item1,item2,item3)
        val adapter=IntroViewPagerAdapter(items)
        viewPager.adapter=adapter

    }


}