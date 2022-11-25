package com.example.todoex2

import android.content.Intent
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoex2.databinding.FragmentTodoBinding


class TodoFragment : Fragment(), View.OnClickListener {
    private val TAG = "TodoFragment"
    private lateinit var binding: FragmentTodoBinding
    lateinit var dbhelper: DBhelper
    lateinit var dbadapter : DBadapter
    val datas = mutableListOf<todoItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
        initializelist()
        initRecycler()//수정할것


    }
    //수정할것
    private fun initRecycler(){
        val dbadapter = DBadapter()
        dbadapter.datas = datas //데이터 넣어줌
        binding.rvTodoList.adapter=dbadapter
        binding.rvTodoList.layoutManager=LinearLayoutManager(context)
    }

    fun initializelist(){
        with(datas){
            add(todoItem("할일", "뭐였더라"))
            add(todoItem("중간평가", "뭐였더라"))
            add(todoItem("리사이클러뷰", "뭐였더라"))
            add(todoItem("알고리즘과제", "뭐였더라"))
            add(todoItem("db값 불러오기", "뭐였더라"))
            add(todoItem("sqlite", "뭐였더라"))
            add(todoItem("스크롤", "뭐였더라"))
            add(todoItem("테스트", "뭐였더라"))
            add(todoItem("스크롤", "뭐였더라"))
            add(todoItem("테스트", "뭐였더라"))
            add(todoItem("스크롤", "뭐였더라"))
            add(todoItem("테스트", "뭐였더라"))
        }
    }

    private fun setOnClickListener() {
        val floatSequence = binding.container.children
        floatSequence.forEach { fab->
            fab.setOnClickListener(this)

        }
    }


    companion object {
        private const val TAG = "TodoFragment"
        fun instance() = TodoFragment()
    }

    override fun onClick(v:View) {
        val intent = Intent(context, EditTodoActivity::class.java)
       when(v.id){
           R.id.fabAdd->{
               //readDataFuncion()
               //startActivity(intent)
               //initRecycler()
           }

       }
    }
    /*
    private fun readDataFuncion(){
        val data = dbhelper.read_Data()
        val recyclerView = binding.rvTodoList

        if(data!=null && data.count>0){

        }
    }*/
}
