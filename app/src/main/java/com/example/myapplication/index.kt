package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class index : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        var btn: Button =findViewById(R.id.btn)
        btn.setOnClickListener{
            var intent = Intent(this, register::class.java)
            startActivity(intent)
        }
    }
}