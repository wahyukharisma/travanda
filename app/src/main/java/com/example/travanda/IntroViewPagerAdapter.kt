package com.example.travanda

import android.content.Context
import android.support.annotation.NonNull
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class IntroViewPagerAdapter(val mListScreen: List<ScreenItem>):PagerAdapter(){

    override fun isViewFromObject(v: View, `object`: Any): Boolean {
        return v===`object` as View
    }

    override fun getCount(): Int {
        return mListScreen.size
    }

    override fun instantiateItem(parent: ViewGroup, position: Int): Any {
        val view=LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_landing_scene,parent,false)

        val intro_title:TextView=view.findViewById(R.id.intro_title)
        val intro_desc:TextView=view.findViewById(R.id.intro_description)
        val intro_img:ImageView=view.findViewById(R.id.intro_img)

        intro_title.text=mListScreen.get(position).title
        intro_desc.text=mListScreen.get(position).description
        intro_img.setImageResource(R.drawable.ic_email_blue_24dp)

        parent?.addView(view)

        return view
    }

    override fun destroyItem(parent: ViewGroup, position: Int, `object`: Any) {
        parent.removeView(`object` as View)
    }

}