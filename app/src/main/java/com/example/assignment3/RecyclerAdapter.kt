package com.example.assignment3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(var data:ArrayList<Restaurant>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
      //var data:ArrayList<Restaurant>?=null
        //private lateinit var db:DatasbaseHandler
      var title = mutableListOf<String>("Whataburger",
            "Fry Nation" ,
            "Burgerlords." ,
            "Project Pollo." ,
            "Pizza Pit." ,
            "Plant Power Fast Food." ,
            "Arctic Circle." ,
            "Wok to Walk")
     var rating = mutableListOf<Float>(5F, 2.5F,3.5F,4F,4.5F,3F,1F,5F)
     var location = mutableListOf<String>("17 C Khyaban-e-Jinnah","Khayaban-e-Firdousi، Road","1 GCP, Near Shoukat Khanum Hospital","916 - R1 Khayaban-e-Firdousi","F774+W3Q","Plaza No, 3","Plot # 26","PIA Main Boulevard")
     var phone= mutableListOf<String>("(661) 237-3327" ,
            "(232) 639-8630" ,
            "(428) 862-3070" ,
            "(270) 654-3402" ,
            "(747) 720-1447" ,
            "(445) 811-2057" ,
            "(265) 576-6603" , 
            "(848) 592-2905")
     var description= mutableListOf<String>("I applied for the position after reading the job description","I applied for the position after reading the job description","I applied for the position after reading the job description","I applied for the position after reading the job description","I applied for the position after reading the job description","I applied for the position after reading the job description","I applied for the position after reading the job description","I applied for the position after reading the job description")
    /*init {
        data=db.readData()
    }*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {

        val temp=LayoutInflater.from(parent.context).inflate(R.layout.cardlayout,parent,false)

        return ViewHolder(temp)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemName.setText(data.get(position).name)
        holder.itemLocation.setText(data.get(position).Location)
        holder.itemRating.setText(data.get(position).rating.toString())
        holder.itemDescription.setText(data.get(position).Description)
        holder.itemPhone.setText(data.get(position).phone)
    }

    override fun getItemCount(): Int {
        return title.size
    }
    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var itemName: TextView
        var itemLocation: TextView
        var itemPhone: TextView
        var itemDescription: TextView
        var itemRating: TextView

        init {
            itemName=itemView.findViewById(R.id.restaurantname)
            itemLocation=itemView.findViewById(R.id.location)
            itemPhone=itemView.findViewById(R.id.phone)
            itemDescription=itemView.findViewById(R.id.description)
            itemRating=itemView.findViewById(R.id.rate)
        }
    }

}