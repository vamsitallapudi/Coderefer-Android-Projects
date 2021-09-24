package com.wwt.nimbleviewing.ui

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


suspend fun main() = coroutineScope {
    launch {
        val time = measureTimeMillis {
            val x = async { doSomethingUsefulOne() }
            val y = async { doSomethingUsefulTwo() }
            println("Sum of x and y is ${x.await() + y.await()}")
        }
        println("Time taken is $time")
    }
    println()
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L)
    return 10
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(2000L)
    return 29
}




