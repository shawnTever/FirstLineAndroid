package com.example.firstlineandroid

open class Person(val name: String, val age: Int) {
    open fun eat() {
        println(name + "is eating. He is " + age + "years old.")
    }
}

class Student(val sno: String, val grade: Int, name: String, age: Int) : Person(name, age), Study {
    init {
        println("sno is$sno")
        println("grade is $grade")

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

    }

    override fun doHomework() {

    }

}