package com.example.myapplication.addBook

import com.example.myapplication.model.ModelBook

class BookRepository {
    val list = mutableListOf<ModelBook>()
    val newlist = mutableListOf<ModelBook>()
    fun addBook(modelBook: ModelBook){
        list.add(modelBook)
    }
    fun searchBook(text : String){
        for (i in list){
            if (i.title!!.lowercase().contains(text.lowercase())){
                newlist.add(i)
            }
        }
    }
    fun deleteContact(modelBook: ModelBook){
        list.remove(modelBook)
    }
    fun getAllBook() : List<ModelBook>{
        return list
    }
    fun getAllBookSearch() : List<ModelBook>{
        return newlist
    }
}