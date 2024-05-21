package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.addBook.AddBook
import com.example.myapplication.fragments.AudioBook
import com.example.myapplication.fragments.ReadBook
import com.google.android.material.bottomnavigation.BottomNavigationView

class Aidio_Read_Book : AppCompatActivity() {
    lateinit var btnNav : BottomNavigationView
    lateinit var btnAudio : Button
    lateinit var btnRead : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aidio_read_book)
        btnNav = findViewById(R.id.bottomNavigationView) as BottomNavigationView
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
        btnNav.setOnItemSelectedListener{
            checkIteminBottomm(it.itemId)
        }

    }
    fun checkIteminBottomm(butonBottom:Int ): Boolean {
        var isActive = when(butonBottom){
            R.id.add_book -> {
                startActivity(Intent(application, AddBook::class.java))
                true}
            R.id.home_book -> {
                startActivity(Intent(application, MainActivity::class.java))
                true
            }
            else -> false
        }
        return isActive
    }
}