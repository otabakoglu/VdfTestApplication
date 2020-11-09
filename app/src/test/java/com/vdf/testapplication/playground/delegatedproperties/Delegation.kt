package com.vdf.testapplication.playground.delegatedproperties

import org.junit.Test

interface Base {
   val message: String
   fun print()
}

class BaseImpl(x: Int):
    Base {
    override val message: String = "BaseImpl: x = $x"
    override fun print() {
        println(message)
    }

}

class Derived(b: Base): Base by b

class Delegation {

    @Test
    fun test_1(){
        val b =
            BaseImpl(10)
        val derived =
            Derived(b)
        println(derived.message)
        derived.print()
    }

}