package com.vdf.testapplication.playground.delegatedproperties

import org.junit.Test
import kotlin.reflect.KProperty

class Delegate {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

class Example {
    var p: String by Delegate()
}


class DelegatedProperties {

    @Test
    fun test_1(){

        val e = Example()
        print(e.p)

        e.p = "New"
    }

}