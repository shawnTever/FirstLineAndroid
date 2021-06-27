package com.example.firstlineandroid

import android.util.Log

open class Person(val name: String, val age: Int) {
    open fun eat() {
        println(name + "is eating. He is " + age + "years old.")
    }
}

open class Student(val sno: String, val grade: Int, name: String, age: Int) : Person(name, age), Study {
    init {
        Log.d("sno","sno is$sno")
        Log.d("grade","grade is $grade")

    }

    override fun eat() {
        super.eat()
        println(name + "is eating. He is " + age + "years old.")
    }

    constructor(name: String, age: Int) : this("", 0, name, age) {

    }

    constructor() :this("", 0) {

    }

    override fun readBooks() {
        Log.d("read","$name is reading")
    }

    override fun doHomework() {
        Log.d("doHomework","$name is doing homework")
    }

}