package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var email: EditText = findViewById(R.id.email)
        var password: EditText = findViewById(R.id.password)

        var btnlogin: Button = findViewById(R.id.btnlogin)


        btnlogin.setOnClickListener{
            if (!email.text.isEmpty() && password.text.length > 8) {
                var i= Intent(this,MainActivity::class.java)
                startActivity(i)

            } else {
                Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show()
            }
        }
    }
}