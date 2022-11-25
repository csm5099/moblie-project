package com.example.todoex2

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.example.todoex2.DBcontainer.TodoTable.Companion.CONTENT_COLUMN
import com.example.todoex2.DBcontainer.TodoTable.Companion.TABLE_NAME
import com.example.todoex2.DBcontainer.TodoTable.Companion.TITLE_COLUMN


class DBhelper (context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION ){

    @SuppressLint("RestrictedApi")
    override fun onCreate(db: SQLiteDatabase?) {

        val todoTable = "CREATE TABLE "+
                TABLE_NAME+"("+
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                TITLE_COLUMN+" TEXT,"+
                CONTENT_COLUMN+" TEXT"+")"
        db!!.execSQL(todoTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
    }

    //Insert
    fun insertData(title:String, content:String):Boolean{
        val db:SQLiteDatabase=this.writableDatabase
        val contentValues=ContentValues()
        contentValues.put(TITLE_COLUMN, title)
        contentValues.put(CONTENT_COLUMN, content)
        val insert_data = db.insert(TABLE_NAME, null, contentValues)
        db.close()

        return !insert_data.equals(-1)
    }
    //read data
    fun read_Data() : Cursor{
        val db : SQLiteDatabase = this.writableDatabase
        val read : Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        return read
    }

    companion object {
        private const val DATABASE_NAME="Todolist.db"
        private const val DATABASE_VERSION=1
    }

}
