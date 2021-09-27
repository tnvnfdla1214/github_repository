package com.example.github_repository

import kotlinx.coroutines.*
import org.junit.Test
import kotlin.system.measureTimeMillis


class Cancellation_and_Timeouts {
    @Test
    fun main1() = runBlocking {
       val job = launch { //1000번을 돌면서 0.5초마다 출력
           repeat(1000) { i ->
               println("job: I'm sleeping $i ...")
               delay(500L)
           }
       }
       delay(1300L)
       println("main : I'm tired of waiting!")
       job.cancel()
       job.join()
       println("main : now Ican quit.")
    }
    @Test
    fun main2() = runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancelAndJoin() // cancel과 join이 순차적으로 실행되는 함수
        println("main: Now I can quit.")
    }
    @Test
    fun main3() = runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            try{
                var nextPrintTime = startTime
                var i = 0
                while (i < 5) {
                    if (System.currentTimeMillis() >= nextPrintTime) {
                        delay(1L)
                        println("job: I'm sleeping ${i++} ...")
                        nextPrintTime += 500L
                    }
                }
            }catch (e: Exception){
                println("Exception $e")
            }

        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancelAndJoin() // cancel과 join이 순차적으로 실행되는 함수
        println("main: Now I can quit.")
    }
    @Test
    fun main4() = runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (isActive) { // cancellable computation loop
                // print a message twice a second
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancelAndJoin() // cancels the job and waits for its completion
        println("main: Now I can quit.")
    }
    @Test
    fun main5() = runBlocking {
        val job = launch {
            try {
                repeat(1000) { i ->
                    println("job: I'm sleeping $i ...")
                    delay(500L)
                }
            } finally {
                println("job: I'm running finally")
            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancelAndJoin() // cancels the job and waits for its completion
        println("main: Now I can quit.")
    }
}