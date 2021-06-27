package com.example.firstlineandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_first_layout.*

class firstLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_layout)

        /*
                button and toast
         */
        val button1: Button = findViewById(R.id.button)
        button1.setOnClickListener {
            Toast.makeText(this, "You click the Button 1", Toast.LENGTH_SHORT).show()
        }

        button.setOnClickListener {
            Toast.makeText(this, "You click the Button", Toast.LENGTH_SHORT).show()
        }


    }

    /*
    *       创建菜单
    * */

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true //true: 允许菜单显示 false: 菜单无法显示
    }

    /*
    *       菜单响应事件
    * */

    override fun onOptionsItemSelected(item: MenuItem): Boolean  = when (item.itemId){
        R.id.add_item -> {
            Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.remove_item -> {
            Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show()
            true
        }
        else -> true
    }

}