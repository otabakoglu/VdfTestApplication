package com.vdf.testapplication.playground.delegatedproperties

import org.junit.Test
import kotlin.properties.Delegates
import kotlin.reflect.KProperty


class DelegationObservable {

    class User {
        /*
        zero -> first
        first -> second
        */
        var name: String by Delegates.observable("zero") {
            property, oldValue, newValue ->
            println("$oldValue -> $newValue")
        }

        /*
        Bolean dönüş tipi ile değeri kabul etmeyebiliriz.
        0 -> 1
        0 -> 2
        */
        var surname: String by Delegates.vetoable("0"){
                kProperty: KProperty<*>, s: String, s1: String ->
                println("$s -> $s1")
            false
        }
    }

    @Test
    fun test_1(){

        val user =
            User()
        user.name  = "first"
        user.name  = "second"

        user.surname = "1"
        user.surname = "2"

    }

}