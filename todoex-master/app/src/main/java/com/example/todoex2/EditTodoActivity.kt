package com.example.todoex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.todoex2.databinding.ActivityEditTodoBinding

class EditTodoActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditTodoBinding
    lateinit var title : EditText
    lateinit var content : EditText
    lateinit var databaseHelper: DBhelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title=findViewById(R.id.etTodoTitle)
        content=findViewById(R.id.etTodoContent)
        databaseHelper=DBhelper(this)

        binding.btnSave.setOnClickListener {
            insertFunction()
        }
    }
    private fun insertFunction(){
        val strTitle = title.text.toString()
        val strContent = content.text.toString()

        val result : Boolean = databaseHelper.insertData(strTitle, strContent)
        when{
            result -> Toast.makeText(applicationContext, "굿", Toast.LENGTH_LONG).show()
            else -> Toast.makeText(applicationContext, "실패`", Toast.LENGTH_LONG).show()
        }
    }
}