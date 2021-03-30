package com.example.firebaselogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Member

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var auth : FirebaseAuth? = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        if (auth!!.currentUser !=null){
            val it = Intent(this, Member::class.java)
            startActivity(it)
            finish()
        }
        btnlog.setOnClickListener {
            val it = Intent(this, Login::class.java)
            startActivity(it)
        }
    }
}