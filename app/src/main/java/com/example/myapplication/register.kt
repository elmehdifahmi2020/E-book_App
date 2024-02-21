package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var firstname: EditText = findViewById(R.id.firstname)
        var lastname: EditText = findViewById(R.id.lastname)
        var email: EditText = findViewById(R.id.email)
        var password: EditText = findViewById(R.id.password)
        var phone: EditText = findViewById(R.id.phone)

        var btncreate: Button = findViewById(R.id.btncreate)
        var btnl: Button = findViewById(R.id.btnlogin)

        btncreate.setOnClickListener{
            if(!firstname.text.isEmpty() && !lastname.text.isEmpty() && !email.text.isEmpty() && !password.text.isEmpty() && !phone.text.isEmpty()){
                val i= Intent(this,login::class.java)
                startActivity(i)
            }
            else {
                Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show()
            }
        }

        btnl.setOnClickListener {
            val i = Intent(this, login::class.java)
            startActivity(i)
        }
    }
}