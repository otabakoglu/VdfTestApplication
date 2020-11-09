package com.vdf.testapplication.playground.lazy

import org.junit.Test

class Basic {

    private val lazyV: String by lazy {
        println("computed!")
        "result"
    }

    @Test
    fun main(){
        println(lazyV)
        println(lazyV)
    }
}