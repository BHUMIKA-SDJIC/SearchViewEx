package com.example.searchviewex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import java.util.Objects

class MainActivity : AppCompatActivity() {

    lateinit var searchView: SearchView
    lateinit var listView: ListView
    lateinit var list: ArrayList<String>
    lateinit var adapter: ArrayAdapter<*>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView = findViewById(R.id.searchView)
        listView = findViewById(R.id.listView)
        list = ArrayList()
        list.add("Apple")
        list.add("Banana")
        list.add("Pineapple")
        list.add("Orange")
        list.add("Mango")
        list.add("Grapes")
        list.add("Lemon")
        list.add("Melon")
        list.add("Watermelon")
        list.add("Papaya")
        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String): Boolean {
                    if (list.contains(query))
                    {
                        adapter.filter.filter(query)
                    }
                    else {
                        Toast.makeText(this@MainActivity, "No Match found", Toast.LENGTH_LONG)
                            .show()
                    }
                    return false
                }
            override fun onQueryTextChange(newText: String): Boolean
            {
                adapter.filter.filter(newText)
                return false
            }
        })
    }
}


