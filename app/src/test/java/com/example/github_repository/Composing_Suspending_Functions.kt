package com.example.github_repository

import kotlinx.coroutines.*
import org.junit.Test

import org.junit.Assert.*
import kotlin.system.measureTimeMillis

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class Composing_Suspending_Functions {
    @Test
    fun main1() = runBlocking {
        val time = measureTimeMillis {
            val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
            val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
            //one.start() // one을 시작한다.
            //two.start() // two를 시작한다.
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
    }

    @Test
    fun main2() {
        try {
            val time = measureTimeMillis {
                val one = SomethingUsefulOneAsync();
                val two = SomethingUsefulTwosync();
                println("my execeptions")
                throw Exception("my execeptions")

                runBlocking {
                    println("The answer is ${one.await()+two.await()}")
                }
            }
            println("Completed in $time ms")
        }catch (e : Exception){
        }
        runBlocking {
            delay(100000)
        }

    }
    fun SomethingUsefulOneAsync() = GlobalScope.async {
        println("start, SomethingUsefulOneAsync")
        val res=doSomethingUsefulOne()
        println("end, SomethingUsefulOneAsync")
        res
    }
    fun SomethingUsefulTwosync() = GlobalScope.async {
        println("start, SomethingUsefulTwosync")
        val res=doSomethingUsefulOne()
        println("end, SomethingUsefulTwosync")
        res
    }

    @Test
    fun main3() = runBlocking{
        val time = measureTimeMillis {
            println("The answer is ${concurrentSum()}")
        }
        println("Completed in $time ms")
    }
    suspend fun concurrentSum() : Int = coroutineScope {
        val one = async{ doSomethingUsefulOne() }
        val two = async{ doSomethingUsefulTwo() }
        one.await()+two.await()
    }
    suspend fun doSomethingUsefulOne(): Int {
        delay(1000L) // pretend we are doing something useful here
        return 13
    }

    suspend fun doSomethingUsefulTwo(): Int {
        delay(1000L) // pretend we are doing something useful here, too
        return 29
    }
}