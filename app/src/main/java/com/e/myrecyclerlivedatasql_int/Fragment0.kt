package com.e.myrecyclerlivedatasql_int

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment0 : Fragment() {

    companion object {
        fun newInstance() = Fragment0()
    }

    private lateinit var viewModel: Fragment0ViewModel

    private lateinit var adapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment0_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Fragment0ViewModel::class.java)

        viewModel._countries.observe(viewLifecycleOwner, Observer {
            adapter.countries = it
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        adapter = MyAdapter();

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(context)

        val addButton = view.findViewById<View>(R.id.button)
        val country = view.findViewById<EditText>(R.id.edit_country)
        val city = view.findViewById<EditText>(R.id.edit_city)

        addButton.setOnClickListener(View.OnClickListener {
            viewModel.add(country.text.toString(), city.text.toString())

        })

    }

}