package com.example.affirmations.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

val TAG = "MainActivity"

class ItemAdapter (private val context: Context, private val affirmations: List<Affirmation>):
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutAdapter = LayoutInflater.from(parent.context).
                inflate(R.layout.list_item, parent, false)
        return ViewHolder(layoutAdapter)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = affirmations[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return affirmations.size
    }

    class ViewHolder(private val view: View):RecyclerView.ViewHolder(view) {
        val titleText: TextView = view.findViewById(R.id.item_title)

        init{
            view.setOnClickListener {
                Toast.makeText(view.context, "Clicked ItemAdapter.ViewHolder", Toast.LENGTH_SHORT).show()
            }
        }

        fun bind(item: Affirmation) {
            titleText.text = view.context.getString(item.stringResourceId)
        }

    }
}