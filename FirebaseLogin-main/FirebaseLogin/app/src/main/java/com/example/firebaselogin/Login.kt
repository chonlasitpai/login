package com.example.firebaselogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import java.lang.reflect.Member

class Login : AppCompatActivity() {
    var auth : FirebaseAuth?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        if (auth!!.currentUser !=null){
            val it = Intent(this, Member::class.java)
            startActivity(it)
            finish()
        }
        btnlog2.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val pass = edtPassword.text.toString().trim()

            if (email.isEmpty()){

                Toast.makeText(this,"กรุณากรอกEmail", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (pass.isEmpty()){
                Toast.makeText(this,"กรุณากรอกPassword", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            auth!!.signInWithEmailAndPassword(email,pass).addOnCompleteListener { task ->
                if (!task.isSuccessful){
                    if(pass.length<8){
                        edtPassword.error="กรอกรหัสผ่านให้มากกว่า8ตัวอักษร"
                    }else{
                        Toast.makeText(this,"Login ล้มเหลว เนื่องจาก:"+task.exception!!.message,
                            Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(this,"Login Success!", Toast.LENGTH_LONG).show()
                    val  it = Intent(this, Member::class.java)
                    startActivity(it)
                    finish()
                }
            }
        }
        register1.setOnClickListener {
            val it = Intent(this,Register::class.java)
            startActivity(it)
        }
        btnback.setOnClickListener {
            onBackPressed()
        }
    }
}