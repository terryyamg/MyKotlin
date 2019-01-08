package com.terryyamg.mykotlin

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_activity_item.view.*

class MainActivity : AppCompatActivity() {

    private val listItem: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listItem.add("Button Type")
        listItem.add("Text Type")

        rvActivity.layoutManager = LinearLayoutManager(this)
        rvActivity.adapter = MainAdapter(listItem, this) {
            Log.i("123","223")
        }

    }
}


class MainAdapter(private val items: ArrayList<String>, private val context: Context, val listener: (Int) -> Unit) :
    RecyclerView.Adapter<MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.list_activity_item, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder?.tvType?.text = items[position]
        holder.bind(items[position], position, listener)
    }

}

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvType = itemView.tvItem!!

    fun bind(item: String, pos: Int, listener: (Int) -> Unit) = with(itemView) {
        itemView.setOnClickListener {
            listener(pos)
        }
    }
}