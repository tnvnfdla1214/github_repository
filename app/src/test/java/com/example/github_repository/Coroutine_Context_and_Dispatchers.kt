package com.example.github_repository

import kotlinx.coroutines.*
import org.junit.Test
import kotlin.system.measureTimeMillis

class Coroutine_Context_and_Dispatchers {
    private val mainScope = MainScope()

    fun destroy() {
        mainScope.cancel()
    }
    fun doSomething() {
        // launch ten coroutines for a demo, each working for a different time
        repeat(10) { i ->
            mainScope.launch {
                delay((i + 1) * 200L) // variable delay 200ms, 400ms, ... etc
                println("Coroutine $i is done")
            }
        }
    }
} // class Activity ends
fun main() = runBlocking {
    val activity = Coroutine_Context_and_Dispatchers()
    activity.doSomething() // run test function
    println("Launched coroutines")
    delay(500L) // delay for half a second
    println("Destroying activity!")
    activity.destroy() // cancels all coroutines
    delay(3000) // visually confirm that they don't work
}