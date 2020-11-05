package com.e.myrecyclerlivedatasql_int

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// adapter get a lambda expression in the constructor
class MyAdapter (): RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    // mutableListOf can be changed, ListOf can not be changed
   var countries = mutableListOf<Country>()
       set(value) {
           field = value
           notifyDataSetChanged()
       }

    // creating viewHolder
    // creating UI structure for the data, for a single row
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        // building View from xml
        val view = layoutInflater.inflate(R.layout.row, parent, false)

        // buliding view holder
        return ViewHolder(view)
    }

    // put the data inside the viewHolder
    // position - the position of the row to show to the user
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]

        holder.country.text = country.name

        val cityView = holder.city
        cityView.text = country.capital

    }

    // total items we want to show
    override fun getItemCount(): Int {
        return countries.size
    }

/*    fun add(name: String, capital: String) {
        val country = Country(name, capital)
        countries.add(country)

        // refresh the adapter
        notifyDataSetChanged()
    }*/

    // itemView is the graphic parent of the row
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val country: TextView = itemView.findViewById(R.id.row_country)
        val city: TextView = itemView.findViewById(R.id.row_city)

        // adding in order to add to it click event
        val parent: View = itemView.findViewById(R.id.row_parent)
    }


}