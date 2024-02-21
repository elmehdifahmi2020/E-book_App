package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.CustomAdapter
import com.example.myapplication.R
import com.example.myapplication.addBook.AddBook_MVVM
import com.example.myapplication.model.ModelBook

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AudioBook.newInstance] factory method to
 * create an instance of this fragment.
 */
class AudioBook : Fragment(),CustomAdapter.OnItemClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var bookList : ArrayList<ModelBook>
    private lateinit var customAdapter: CustomAdapter
    private lateinit var viewModel : AddBook_MVVM
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_audio_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bookList = ArrayList()
        customAdapter = CustomAdapter(bookList,this)
        bookList.add(ModelBook("Palestine",R.drawable.download))
        bookList.add(ModelBook("Morroco",R.drawable.download))
        bookList.add(ModelBook("Alegmant",R.drawable.download))
        bookList.add(ModelBook("Egypt",R.drawable.download))
        bookList.add(ModelBook("Palestine",R.drawable.download))
        bookList.add(ModelBook("Morroco",R.drawable.download))
        bookList.add(ModelBook("Alegmant",R.drawable.download))
        bookList.add(ModelBook("Egypt",R.drawable.download))
        bookList.add(ModelBook("Palestine",R.drawable.download))
        bookList.add(ModelBook("Morroco",R.drawable.download))
        bookList.add(ModelBook("Alegmant",R.drawable.download))
        bookList.add(ModelBook("Egypt",R.drawable.download))
        val recy = view.findViewById<RecyclerView>(R.id.frg_View_Audio)
        val gridLayoutManager = GridLayoutManager(context,2)
        recy.layoutManager = gridLayoutManager
        recy.adapter = customAdapter
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AudioBook.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AudioBook().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onItemSelected(modelBook: ModelBook) {
        TODO("Not yet implemented")
    }
}