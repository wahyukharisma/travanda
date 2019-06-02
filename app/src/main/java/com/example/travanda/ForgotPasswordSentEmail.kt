package com.example.travanda

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.email_sent.*

class ForgotPasswordSentEmail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.email_sent)

        btn_move_login.setOnClickListener {
            val intent = Intent (this, Login::class.java)
            startActivity(intent)
        }
    }
}