package com.example.todoex2

import android.provider.BaseColumns

object DBcontainer {

    class TodoTable:BaseColumns{
        companion object{
            val TABLE_NAME="Todo_table"
            val TITLE_COLUMN="TITLE"
            val CONTENT_COLUMN="CONTEMT"
        }
    }
}