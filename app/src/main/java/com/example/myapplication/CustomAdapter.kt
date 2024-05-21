package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.ModelBook

class CustomAdapter(private val dataSet: List<ModelBook>,private val listner : OnItemClickListener) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView

        //var btnremove:ImageView = view.findViewById(R.id.btnremove)

        init {
            textView = view.findViewById(R.id.title_book)
            imageView = view.findViewById(R.id.pic_book)
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.view_model, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position].title
        viewHolder.imageView.setImageResource(dataSet[position].ImageBook)
        viewHolder.itemView.setOnClickListener {
            listner.onItemSelected(dataSet[position])
        }
//        viewHolder.btnremove.setOnClickListener {
//            for (x in dataSet){
//                dataSet.remove(dataSet)
//            }

            //Toast.makeText(this, "This is a short toast message", Toast.LENGTH_SHORT).show()

            //notifyDataSetChanged()
        //}
    }

    override fun getItemCount() = dataSet.size

    interface OnItemClickListener {
        fun onItemSelected(modelBook: ModelBook)
    }


}


