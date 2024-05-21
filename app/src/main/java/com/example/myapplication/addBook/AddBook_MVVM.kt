package com.example.myapplication.addBook

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.ModelBook

class AddBook_MVVM : ViewModel(){
    private val repository = BookRepository()
    private val list = MutableLiveData<List<ModelBook>>()
    init {
        list.value = listOf()
    }
    fun addBook(book: ModelBook){
        repository.addBook(book)
    }
    fun searchBook(text : String){
        repository.searchBook(text)
    }
    fun deleteBook(book: ModelBook){
        repository.deleteContact(book)
    }
    fun allBook() : List<ModelBook> {
        return  repository.getAllBook()
    }
    fun getAllBook() : MutableLiveData<List<ModelBook>> {
        list.value = repository.getAllBook()
        return list
    }
    fun getAllBookSearch() : MutableLiveData<List<ModelBook>>{
        list.value = repository.getAllBookSearch()
        return list
    }
    fun deleteBookById(id : Int){
        repository.deleteBookByInt(id)
        }
}