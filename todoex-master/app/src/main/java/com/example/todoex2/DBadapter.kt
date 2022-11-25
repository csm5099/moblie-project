package com.example.todoex2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.todoex2.databinding.ItemTodoListBinding
import java.lang.reflect.Type

class DBadapter ():RecyclerView.Adapter<DBadapter.ViewHolder>(){
        var datas = mutableListOf<todoItem>()

    //만들어진 뷰홀더 없을 때 뷰홀더(레이아웃 생성)
        override fun onCreateViewHolder(parent:ViewGroup, viewType: Int):ViewHolder{
           val binding = ItemTodoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return  ViewHolder(binding)
        }

    override fun getItemCount(): Int =datas.size

    //리사이클러뷰가 뷰홀더를 가져와 데이터를 연결할 때 호출
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }
    inner class ViewHolder(private val binding: ItemTodoListBinding):RecyclerView.ViewHolder(binding.root){

        //todolist에 들어가는 거..
        fun bind(item:todoItem){
            binding.tvTodoItem.text = item.title
            }
    }
    }