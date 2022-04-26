package com.example.assignment3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Addinfo:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addpage)
        val context=this
        val name=findViewById<EditText>(R.id.editTextTextPersonName)
        val Loc=findViewById<EditText>(R.id.editTextTextPersonlocation)
        val phone=findViewById<EditText>(R.id.editTextTextPersonPhone)
        val des=findViewById<EditText>(R.id.editTextTextDescription)
        val rate=findViewById<EditText>(R.id.editTextTextPersonRating)
        val btn=findViewById<Button>(R.id.add_res)
        btn.setOnClickListener {
            if(name.text.toString().isNotEmpty() && Loc.text.toString().isNotEmpty() && phone.text.toString()
                    .isNotEmpty() && des.text.toString().isNotEmpty() && rate.text.toString()
                    .isNotEmpty()
            )
            {
                var res=Restaurant(name.text.toString(),des.text.toString(),phone.text.toString(),Loc.text.toString(),rate.text.toString().toInt())
                var db=DatasbaseHandler(context)
                db.insertdata(res)
                val i=Intent(this,MainActivity::class.java)
                startActivity(i)
            }
            else
            {
                Toast.makeText(context,"Please fill out all the info",Toast.LENGTH_SHORT).show()
            }

        }
    }
}