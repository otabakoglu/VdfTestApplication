package com.vdf.testapplication.playground.delegatedproperties

import org.junit.Test
import java.util.*


class LocalDelegatedProperties {

    class Foo {
        fun isValid(): Boolean = true
        fun doSomething() {
            println("Something!")
        }
    }

    private fun example(computeFoo: () -> Foo) {
        val memorizedFoo by lazy(computeFoo)
        if(memorizedFoo.isValid()){
            memorizedFoo.doSomething()
        }
    }


    @Test
    fun test_1(){
        example { Foo() }

    }

}