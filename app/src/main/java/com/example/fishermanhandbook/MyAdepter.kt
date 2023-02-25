package com.example.fishermanhandbook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdepter(listArray: ArrayList<ListItem>, context: Context): RecyclerView.Adapter<MyAdepter.ViewHolder>() {
    var listArrayR = listArray
    var contextR = context
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvContent = view.findViewById<TextView>(R.id.tvContent)
        val imV = view.findViewById<ImageView>(R.id.imImageView)

        fun bind(listIt: ListItem, context: Context) {
            tvTitle.text = listIt.titleText
            tvContent.text = listIt.contentText
            imV.setImageResource(listIt.image_id)
            itemView.setOnClickListener(){
                Toast.makeText(context, "Preset : ${tvTitle.text}", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val iflater = LayoutInflater.from(contextR)
        return ViewHolder(iflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listitem = listArrayR[position]
        holder.bind(listitem, contextR)
    }
}