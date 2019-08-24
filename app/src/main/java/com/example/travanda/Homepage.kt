package com.example.travanda

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.homepage.*

class Homepage : AppCompatActivity(), View.OnClickListener {
    private var mAuth:FirebaseAuth?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)

        val isFirstRun :Boolean = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).getBoolean("isFirstRun", true)
        if(isFirstRun){
            val intent=Intent(this,OnLanding::class.java)
            startActivity(intent)
        }
        getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit().putBoolean("isFirstRun",false).commit()

        //button on homepage
            //Authorized
            btn_edit_profile.setOnClickListener (this)
            btn_logout.setOnClickListener (this)
            //Unauthorized
            btn_login.setOnClickListener (this)
        mAuth = FirebaseAuth.getInstance()

    }

    override fun onStart() {
        super.onStart()
        val currentUser=mAuth!!.currentUser
        updateUI(currentUser)
    }

    override fun onClick(v: View?) {
        val i=v!!.id
        if(i==R.id.btn_edit_profile){
//            val intent=Intent(this,)
        }else if(i==R.id.btn_logout){
            mAuth!!.signOut()
            finish()
            startActivity(getIntent())
        }else if(i==R.id.btn_login){
            val intent=Intent(this,Login::class.java)
            startActivity(intent)
            finish()

        }
    }
    private fun updateUI(user: FirebaseUser?){
        if(user!=null){
            btn_edit_profile.visibility= View.VISIBLE
            btn_logout.visibility=View.VISIBLE
            btn_login.visibility=View.GONE
        }
        else{
            btn_login.visibility=View.VISIBLE
            btn_edit_profile.visibility= View.GONE
            btn_logout.visibility=View.GONE
        }
    }
}
