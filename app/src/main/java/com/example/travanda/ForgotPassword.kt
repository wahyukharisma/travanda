package com.example.travanda

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.forgot_password_landing.*

class ForgotPassword : AppCompatActivity(){
    private var mAuth : FirebaseAuth?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgot_password_landing)
        mAuth=FirebaseAuth.getInstance()
        btn_submit_email.setOnClickListener {
            val email= et_email_input.text.toString().trim()
            if(TextUtils.isEmpty(email)){
                Toast.makeText(applicationContext,"Enter your email",Toast.LENGTH_SHORT).show()
            }
            else{

                mAuth?.sendPasswordResetEmail(email)?.addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this@ForgotPassword,"Check email to reset your password!",Toast.LENGTH_SHORT ).show()
                        val intent= Intent(this, ForgotPasswordSentEmail::class.java)
                        startActivity(intent)
                    } else{
                        Toast.makeText(this@ForgotPassword,"Fail to send reset password email!!",Toast.LENGTH_SHORT ).show()
                        val intent= Intent(this, Login::class.java)
                        startActivity(intent)
                    }
                }
            }

        }

    }
}