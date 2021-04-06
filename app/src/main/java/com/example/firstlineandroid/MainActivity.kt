package com.example.firstlineandroid

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var timeChangeReceiver: TimeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "OnCreate execute")
        Log.i("data", "OnCreate execute")

        val p = Person("Jack", 19)
        p.eat()

/*
*       list set and map
* */

        val list = mutableListOf("apple", "Banana")
        list.add(" ")

        for (fruit in list) {
            Log.d("list set and map", "each fruit in the list: $fruit")
        }

        val set = mutableSetOf("apple", "Banana")
        list.add(" ")

        for (fruit in set) {
            Log.d("list set and map", "each fruit in the set: $fruit")
        }

        val map = HashMap<String, Int>()
        map["apple"] = 1

        val map1 = mapOf("Apple" to 1, "Banana" to 2)
        val map2 = mutableMapOf("Apple" to 1, "Banana" to 2)

        for ((fruit, number) in map) {
            Log.d("list set and map", "each fruit in the map: $fruit, value: $number")
        }
/*
*       单例模式
* */
        Singleton.singletonTest()

/*
*       集合函数式API
*       lambda: any判断是否有元素满足指定条件
*               all判断是否所有元素满足指定条件
* */
        val maxLength = list.maxBy { it.length }

        val lambda = {fruit: String -> fruit.length}
        val maxLengthFruit1 = list.maxBy(lambda)

        val maxLengthFruit2 = list.maxBy{ fruit -> fruit.length }
        val maxLengthFruit3 = list.maxByOrNull { it.length }

        val newList1 = list.map { it.toUpperCase() }
        val newList2 = list.filter { it.length <= 5 }
                .map { it.toUpperCase() }

        val anyResult = list.any { it.length <= 5 }
        val allResult = list.all { it.length <= 5 }

/*
*       结合线程的Runnable接口
* */
        Thread(object :Runnable {
            override fun run() {
                Log.d("runnable", "Thread is running")
            }
        }).start()

        Thread { Log.d("runnable", "Thread is running") }.start()

/*
*       结合线程的Runnable接口
* */


        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).apply {
            addAction(Intent.ACTION_MANAGE_NETWORK_USAGE)
        }

        val intentFilter = IntentFilter()
        intentFilter.addAction("Android.intent.action.TIME_TICK")
        timeChangeReceiver = TimeChangeReceiver()
        registerReceiver(timeChangeReceiver, intentFilter)

        val br: BroadcastReceiver = MyBroadcastReceiver()
        registerReceiver(br, filter)

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }

    inner class TimeChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Toast.makeText(context, "Time has changed", Toast.LENGTH_SHORT).show()
        }

    }
}