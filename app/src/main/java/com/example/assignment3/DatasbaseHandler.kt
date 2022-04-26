package com.example.assignment3

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

const val DATABASE_NAME ="My restaurant"
const val TABLE_NAME ="RESTAURANTS"
const val COL_ID="id"
const val COL_NAME="name"
const val COL_DESCRIPTION="description"
const val COL_PHONE="phone"
const val COL_LOCATION="location"
const val COL_RATING="rating"

class DatasbaseHandler(var context: Context):SQLiteOpenHelper(context, DATABASE_NAME,null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        val createTable="CREATE TABLE"+ TABLE_NAME+" ("+ COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ COL_NAME+" TEXT,"+ COL_LOCATION+" TEXT,"+ COL_PHONE+" TEXT,"+ COL_DESCRIPTION+" TEXT,"+ COL_RATING+" INTEGER)";
        p0?.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(p0)
    }
    fun insertdata(temp:Restaurant){
        val db:SQLiteDatabase=this.writableDatabase
        var cv=ContentValues()
        cv.put(COL_NAME,temp.name)
        cv.put(COL_LOCATION,temp.Location)
        cv.put(COL_PHONE,temp.phone)
        cv.put(COL_DESCRIPTION,temp.Description)
        cv.put(COL_RATING,temp.rating)
        var result = db.insert(TABLE_NAME,null,cv)
        if(result== (-1).toLong())
        {
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
        }


    }
    fun readData():ArrayList<Restaurant>{
        var list:ArrayList<Restaurant> =ArrayList()
        val db:SQLiteDatabase=this.readableDatabase
        val query ="SELECT * FROM "+ TABLE_NAME
        val result=db.rawQuery(query,null)
        if(result.moveToFirst())
        {
            do {
                var res= Restaurant()
                res.name = result.getString(1)
                res.Location = result.getString(2)
                res.phone = result.getString(3)
                res.Description = result.getString(4)
                res.rating = result.getString(5).toInt()
                list.add(res)
            }while (result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }
}