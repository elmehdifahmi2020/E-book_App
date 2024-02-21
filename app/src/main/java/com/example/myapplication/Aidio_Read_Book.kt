package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.fragments.AudioBook
import com.example.myapplication.fragments.ReadBook

class Aidio_Read_Book : AppCompatActivity() {
    lateinit var btnAudio : Button
    lateinit var btnRead : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aidio_read_book)
        btnAudio = findViewById(R.id.Audio_book)
        btnRead = findViewById(R.id.Ebook)
        btnAudio.setOnClickListener {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.myFrg, AudioBook())
            ft.commit() }
        btnRead.setOnClickListener {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.myFrg, ReadBook())
            ft.commit() }
    }
}