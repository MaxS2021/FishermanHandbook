package com.example.fishermanhandbook

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.min

class MyAdepter(listArray: ArrayList<ListItem>, context: Context): RecyclerView.Adapter<MyAdepter.ViewHolder>() {
    var listArrayR = listArray
    var contextR = context
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvContent = view.findViewById<TextView>(R.id.tvContent)
        val imV = view.findViewById<ImageView>(R.id.imImageView)

        fun bind(listIt: ListItem, context: Context) {
            tvTitle.text = listIt.titleText
            val lensub = min(50,listIt.contentText.length )
            val textCont = listIt.contentText.substring(0, lensub) + "..."
            tvContent.text = textCont
            imV.setImageResource(listIt.image_id)
            Log.d("AppLog", "TexCont $textCont")
            itemView.setOnClickListener(){
                Toast.makeText(context, "Preset : ${tvTitle.text}", Toast.LENGTH_SHORT).show()
                val inTent = Intent(context, ContentActivity::class.java)
                inTent.putExtra("title", tvTitle.text.toString())
                inTent.putExtra("content", listIt.contentText)
                inTent.putExtra("imId", listIt.image_id)
                context.startActivity(inTent)
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

    fun updateAdapter(listArry: List<ListItem>) {
        listArrayR.clear()
        listArrayR.addAll(listArry)
        notifyDataSetChanged()
    }
}