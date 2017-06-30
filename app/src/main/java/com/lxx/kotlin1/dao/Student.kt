package com.lxx.kotlin1.dao

/**
 * Created by android on 2017/6/23.
 */
class Student<T> (name: String) : Person, Play {

    var t:T?=null
    var name = ""
    var age = 1
    var sex = false

    init {
        this.name = name
    }

    constructor (name: String, age: Int, sex: Boolean) : this(name) {
        this.age = age
        this.sex = sex
    }


    override fun playTV() {
    }

    override fun eat() {
        println("吃 $age ------  $t")
    }

    override fun see() {
        super<Person>.see()
        super<Play>.see()
        println("看")
    }

    override fun run() {
        println("跑")
    }

}