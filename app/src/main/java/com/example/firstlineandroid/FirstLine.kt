package com.example.firstlineandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class FirstLine : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_line)

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
*       可空类型系统
*       Int 补课为空 Int?可以为空
*       ?: ?.操作符
*       !! 非空断言: 确信一定不为空(有风险)
*       let
* */
        fun doStudy(study: Study?) {
            if (study != null) {
                study.readBooks()
                study.doHomework()
            }
        }

        fun doStudy1(study: Study?) {
                study?.readBooks()
                study?.doHomework()
        }

        val student = Student()
        doStudy(student)

        fun getTextLength(text: String?) = text?.length ?: 0

        fun doStudyLet1(study: Study?) {
            study?.let { stu ->
                stu.readBooks()
                stu.doHomework()}
        }
/*
*       函数参数默认值
* */

        fun printParams(num: Int = 100, str: String = "hello") {
            Log.d("printParams", "num is $num, str is $str")
        }

        printParams(str = "world", num = 123)


    }
}