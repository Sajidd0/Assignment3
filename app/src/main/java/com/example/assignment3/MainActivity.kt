package com.example.assignment3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager?=null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>?=null
    val context=this
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layoutManager=LinearLayoutManager(this)
        var recyclerview =findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager=layoutManager
        var data:ArrayList<Restaurant>
        var db=DatasbaseHandler(this)
        data=db.readData()
        adapter=RecyclerAdapter(data)
        recyclerview.adapter=adapter
        val btn=findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            val i=Intent(this,Addinfo::class.java)
            startActivity(i)
        }
    }
}