package com.example.travanda

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.FirebaseAuthException
import kotlinx.android.synthetic.main.activity_login.*


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_login.setOnClickListener {
            val email= et_email.text.toString()
            val password= et_password.text.toString()
            if(email.isEmpty()||password.isEmpty()){
                Toast.makeText(this,"Please insert email and password",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            //login below
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                .addOnCompleteListener {
                    if(!it.isSuccessful){
                        return@addOnCompleteListener
                    }
                    else {
                        val fbUser = FirebaseAuth.getInstance().currentUser
                        if(fbUser!!.isEmailVerified)
                        {
                            Toast.makeText(this, "Successfully login!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, Homepage::class.java)
                            startActivity(intent)
                            finish()
                        }
                        else{
                            fbUser.sendEmailVerification().addOnCompleteListener { task ->
                                if (task.isSuccessful){
                                    val intent= Intent(this, VerifyEmail::class.java)
                                    startActivity(intent)
                                }
                            }
                        }
                    }
                }
                .addOnFailureListener {
                    Log.d("Login","FailedLogin:${it.message}")
                    Toast.makeText(this,"Email/Password incorrect",Toast.LENGTH_SHORT).show()

                }
        }
        txt_forgot_password.setOnClickListener {
            val intent = Intent (this, ForgotPassword::class.java)
            startActivity(intent)
        }
        txt_signup.setOnClickListener {
            val intent = Intent (this, SignUp::class.java)
            startActivity(intent)
        }
    }
}
