package com.vdf.testapplication.playground.delegatedproperties

import org.junit.Test


class DelegationLazy {

    private val lazyValue: String by  lazy {
        println("computed")
        "hello"
    }
    @Test
    fun test_1(){
        println(lazyValue)
        println(lazyValue)
    }

}