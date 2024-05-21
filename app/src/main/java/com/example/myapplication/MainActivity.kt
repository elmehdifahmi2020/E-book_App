package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SearchView

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.addBook.AddBook
import com.example.myapplication.addBook.AddBook_MVVM
import com.example.myapplication.model.ModelBook
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random


class MainActivity : AppCompatActivity(),CustomAdapter.OnItemClickListener{
    lateinit var btnNav : BottomNavigationView
    lateinit var btnAudio :Button
    lateinit var btnRead :Button
    lateinit var myView : RecyclerView
    lateinit var customAdapter:CustomAdapter
    private lateinit var viewModel : AddBook_MVVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnNav = findViewById(R.id.bottomNavigationView) as BottomNavigationView
        btnAudio = findViewById(R.id.Audio_book)
        btnRead = findViewById(R.id.Ebook)
        myView = findViewById(R.id.View_Bokk)
       val searchView = findViewById<SearchView>(R.id.searchViewBook)
        searchView.setOnQueryTextListener(object  : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.searchBook(newText)
                return true
            }
        })
        var bundel = intent.extras
        val title = bundel?.getString("title")
        val writer = bundel?.getString("writer")
        val price = bundel?.getString("price")
        val type = bundel?.getString("type")
        val listImages = listOf<Int>(R.drawable.cover1,R.drawable.cover2,R.drawable.cover3,R.drawable.cover5,R.drawable.cover6,R.drawable.cover7,R.drawable.cover9,R.drawable.cover10,R.drawable.interstellar)
        val listTitres = listOf<String>( "The Great Gatsby", "To Kill a Mockingbird", "1984", "Pride and Prejudice", "The Catcher in the Rye", "Harry Potter and the Sorcerer's Stone", "The Hobbit", "The Lord of the Rings","inter")
        val listAuthors =  listOf("F. Scott Fitzgerald", "Harper Lee", "George Orwell", "Jane Austen", "J.D. Salinger", "J.K. Rowling", "J.R.R. Tolkien", "J.R.R. Tolkien","mehdi")
        val descriptions = listOf("A novel by F. Scott Fitzgerald about the American Dream and the roaring twenties.",
            "A classic by Harper Lee that addresses racial injustice in the American South.",
            "A dystopian novel by George Orwell depicting a totalitarian regime.",
            "A romantic novel by Jane Austen set in early 19th-century England.",
            "A coming-of-age novel by J.D. Salinger about teenage angst and rebellion.",
            "The first book in the Harry Potter series, introducing the wizarding world.",
            "A fantasy novel by J.R.R. Tolkien about Bilbo Baggins' journey.",
            "An epic fantasy series by J.R.R. Tolkien about the quest to destroy the One Ring."

        )
        val listTypes = listOf("ReadBook","AudioBook")
        val minPrice = 10.0
        val maxPrice = 50.0
        val gridLayoutManager = GridLayoutManager(application,2)
        viewModel = ViewModelProvider(this).get(AddBook_MVVM::class.java)
        viewModel.getAllBook().observe(this) { boklist ->
            customAdapter=CustomAdapter(boklist,this)
            myView.layoutManager = gridLayoutManager
            myView.adapter = customAdapter
         }

        for ( i in 0..listImages.size-1){
            val price = minPrice + Random.nextDouble() * (maxPrice - minPrice)
            val partieDecimale = price.toString().split(".")[1]
            val deuxChiffresApresVirgule = partieDecimale.take(2)
            val randomNumber =  Random.nextInt(2)
            viewModel.addBook(ModelBook(listTitres[i],listImages[i],listAuthors[i], price = deuxChiffresApresVirgule,listTypes[randomNumber],descriptions[i]))
        }


        btnNav.setOnItemSelectedListener{
            checkIteminBottomm(it.itemId)
        }
        btnAudio.setOnClickListener {
            startActivity(Intent(application,Aidio_Read_Book::class.java))
            }
        btnRead.setOnClickListener {
            startActivity(Intent(application,Aidio_Read_Book::class.java))
        }

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val deletedCource :ModelBook = viewModel.allBook().get(viewHolder.adapterPosition)
                val position = viewHolder.adapterPosition
                viewModel.deleteBookById(position)
                customAdapter.notifyItemRemoved(position)
                Snackbar.make(myView,"Deleted"+ deletedCource.title,Snackbar.LENGTH_LONG).show()

            }
        } ).attachToRecyclerView(myView)

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

    override fun onItemSelected(modelBook: ModelBook) {
        val intent = Intent(this@MainActivity,Detailt_activity::class.java)
         val bundle = Bundle()
        val image = bundle?.putInt("image",modelBook.ImageBook)
         val title = bundle?.putString("title",modelBook.title)
        val writer =  bundle?.putString("writer",modelBook.title)
        val price = bundle?.putString("price",modelBook.price)
        val description = bundle?.putString("descriptionn",modelBook.description)
        intent.putExtras(bundle)
        startActivity(intent)


    }



}