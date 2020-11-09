package com.vdf.testapplication.playground.delegatedproperties

import org.junit.Test


class DelegatedMap {

    class User(map: Map<String, Any?>) {
        val name: String by map
        val age: Int by map
    }

    @Test
    fun test_1(){
        val user = User(
            mapOf(
                "name" to "John Doe",
                "age" to 25,
                "name" to "asd"
            )
        )

        println(user.name)
        println(user.age)
    }

}