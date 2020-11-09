package com.vdf.testapplication.playground.delegatedproperties

import org.junit.Test


class DelegationToAnotherProperty {

    class MyClass {
        var newName: Int = 0

        @Deprecated("Use 'newName' instead", ReplaceWith("newName"))
        var oldName: Int = 0 // by this::newName
    }

    @Test
    fun test_1(){
        val myClass =
            MyClass()
        myClass.oldName = 42
        println(myClass.newName)
    }

}


