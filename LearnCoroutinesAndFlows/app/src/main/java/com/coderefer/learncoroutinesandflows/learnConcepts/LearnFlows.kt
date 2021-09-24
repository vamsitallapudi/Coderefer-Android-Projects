package com.coderefer.learncoroutinesandflows.learnConcepts
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun simpleSequence(): Sequence<Int> = sequence {
    for (i in 1..3) {
        Thread.sleep(100)
        yield(i)
    }
}

fun simpleFlow() : Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking {
    withTimeoutOrNull(250) {
        simpleFlow().collect { v -> println(v) }
    }
    (1..3).asFlow().collect { v -> println(v) }
    println("Done")
}