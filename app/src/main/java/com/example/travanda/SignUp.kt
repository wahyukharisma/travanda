package com.example.travanda

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_signup.*

class SignUp : AppCompatActivity() {
    lateinit var ref : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        ref=FirebaseDatabase.getInstance().getReference("users")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        btn_signup.setOnClickListener {
            savedata()
        }
    }
    private fun savedata(){
        val username = et_username.text.toString()
        val email = et_email.text.toString()
        val user = Users(username,email)
        val password = et_password.text.toString()
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
            if (!it.isSuccessful){
                return@addOnCompleteListener
                val intent=Intent(this,SignUp::class.java)
                startActivity(intent)
                }
                val userId= ref.push().key.toString()
                ref.child(userId).setValue(user).addOnCompleteListener(){
                    Toast.makeText(this,"success",Toast.LENGTH_SHORT).show()
                    val intent = Intent (this, Login::class.java)
                    startActivity(intent)
                }
            }
            .addOnFailureListener {
                Toast.makeText(this,"Email/Password incorrect",Toast.LENGTH_SHORT).show()
            }
    }
}