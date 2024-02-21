package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.CustomAdapter
import com.example.myapplication.R
import com.example.myapplication.model.ModelBook

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReadBook.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReadBook : Fragment(),CustomAdapter.OnItemClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var customAdapter : CustomAdapter
    lateinit var bookLists : ArrayList<ModelBook>
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
        return inflater.inflate(R.layout.fragment_read_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bookLists = ArrayList()
        customAdapter = CustomAdapter(bookLists,this)
        bookLists.add(ModelBook("Palestine",R.drawable.download))
        bookLists.add(ModelBook("Morroco",R.drawable.download))
        bookLists.add(ModelBook("Alegmant",R.drawable.download))
        bookLists.add(ModelBook("Egypt",R.drawable.download))
        val recy = view.findViewById<RecyclerView>(R.id.frg_View_Read)
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
         * @return A new instance of fragment ReadBook.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReadBook().apply {
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