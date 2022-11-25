package com.example.todoex2

import android.graphics.Insets.add
import android.os.Bundle
import android.view.SurfaceControl
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets.add
import androidx.core.view.OneShotPreDrawListener.add
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.todoex2.databinding.ActivityNaviBinding


private const val TAG_TODO = "fragment_todo"
private const val TAG_SHOP = "fragment_shop"
private const val TAG_STAT = "fragment_stat"

class NaviActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(TAG_TODO,TodoFragment())


        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.action_todo -> setFragment(TAG_TODO, TodoFragment())
                R.id.action_shop -> setFragment(TAG_SHOP, ShopFragment())//코틀린파일이름으로
                R.id.action_stat-> setFragment(TAG_STAT, StatFragment())
            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()
        val todo = manager.findFragmentByTag(TAG_TODO)
        val shop = manager.findFragmentByTag(TAG_SHOP)
        val stat = manager.findFragmentByTag(TAG_STAT)

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }


        if (todo != null){
            fragTransaction.hide(todo)
        }
        if (shop != null){
            fragTransaction.hide(shop)
        }
        if (stat != null) {
            fragTransaction.hide(stat)
        }

         if (tag == TAG_TODO) {
            if (todo != null) {
                fragTransaction.show(todo)
            }
        }

        else if (tag == TAG_SHOP) {
            if (shop!=null){
                fragTransaction.show(shop)
            }
        }


        else if (tag == TAG_STAT){
            if (stat != null){
                fragTransaction.show(stat)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}