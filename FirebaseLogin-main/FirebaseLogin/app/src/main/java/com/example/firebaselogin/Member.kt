package com.example.firebaselogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_member.*

class Member : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var auth : FirebaseAuth? =null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member)
        auth = FirebaseAuth.getInstance()

        val userData = auth!!.currentUser
        output.text = userData?.uid.toString()+""+userData!!.email

        btnout.setOnClickListener {
            auth!!.signOut()
            Toast.makeText(this,"LogOut Complete", Toast.LENGTH_LONG).show()

            val it = Intent(this,MainActivity::class.java)
            startActivity(it)
            finish()
        }
    }
}