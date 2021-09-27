package com.example.github_repository

import kotlinx.coroutines.*
import org.junit.Test
import kotlin.system.measureTimeMillis

class Basic {

    @Test
    fun main1()  {
        GlobalScope.launch { // coroutineScope
            delay(1000L)
            println("World!")
        }
        println("Hello")
        Thread.sleep(2000L)
    }
    @Test
    fun main2() = runBlocking {
        launch { // 코루틴 빌더
            delay(1000L)
            println("World!")
        }
        println("Hello")
    }
    @Test
    fun main3(){
        Thread {
            Thread.sleep(1000L)
            println("World!")
        }
        println("Hello")
    }
    @Test
    fun main4()  {
        GlobalScope.launch { // 자신이 호출한 쓰레드를 블록킹하지 않는다.
            delay(1000L) //코루틴 안에서만 가능한 function 이다.
            println("World!")
        }
        println("Hello")
        runBlocking { //코루틴 빌더 중 일종이며 자신이 호출한 쓰레드를 블록킹하지 않는다.
            delay(2000L)
        }
    }
    @Test
    fun main5() = runBlocking {
        val job = launch {
            delay(1000L)
            println("World!")
        }
        println("Hello")
        job.join()
    }
    @Test
    fun main6() = runBlocking {
        launch {
            myWorld()
        }
        println("Hello")
    }
    suspend fun myWorld(){
        delay(1000L)
        println("World")
    }
    @Test
    fun main7() = runBlocking {
        repeat(100_000) { // 100000개의 코루틴 점찍기
            launch {
                delay(5000L)
                print(".")
            }
        }
    }
    @Test
    fun main8() = runBlocking {
        repeat(100_000) { // 100000개의 코루틴 점찍기
            Thread {
                Thread.sleep(5000L)
                print(".")
            }
        }
    }
    @Test
    fun main9() = runBlocking {
       GlobalScope.launch {
           repeat(1000){ i ->
               println("I'm sleeping $i ...")
               delay(500L)
           }
       }
        delay(1300L)
    }


}