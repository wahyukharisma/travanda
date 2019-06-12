package com.example.travanda

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
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

        btn_next.setOnClickListener {
            var pager=findViewById(R.id.viewPager) as ViewPager
            var max:Int=adapter.count
            var current:Int=pager.currentItem+1
            if(max==current){
                var start=findViewById(R.id.btn_get_started) as Button
                var next=findViewById(R.id.btn_next) as Button
                next.visibility= View.INVISIBLE
                start.visibility= View.VISIBLE
            }
            else{
                pager.setCurrentItem(pager.getCurrentItem()+1)
            }

        }

    }


}