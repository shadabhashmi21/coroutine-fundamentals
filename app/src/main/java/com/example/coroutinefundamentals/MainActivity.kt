package com.example.coroutinefundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

class MainActivity : AppCompatActivity() {

    private val tag = "CoroutineTag"
    private lateinit var counterText: TextView
    private var counter: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterText = findViewById(R.id.counter_text)

        CoroutineScope(Dispatchers.Main).launch {
            task1()
            task2()
        }
        /*CoroutineScope(Dispatchers.Main).launch {
            task2()
        }*/
    }

    /*fun updateCounter(view: View) {
        counterText.text = counter++.toString();
    }*/
    /*private fun executeLongRunningTask() {
        for (i in 1..10000000000L){

        }
        Log.d(tag, "Task Completed")
    }*/

    /*fun executeTaskEfficiently(view: View){
        CoroutineScope(Dispatchers.IO).launch {
            Log.d(tag, Thread.currentThread().name)
            executeLongRunningTask()
        }

        CoroutineScope(Dispatchers.Main).launch {
            Log.d(tag, Thread.currentThread().name)
        }

        CoroutineScope(Dispatchers.Default).launch {
            Log.d(tag, Thread.currentThread().name)
        }
    }*/

    private suspend fun task1(){
        Log.d(tag, "Task 1 Started")
        yield()
        Log.d(tag, "Task 1 Completed")
    }

    suspend fun task2(){
        Log.d(tag, "Task 2 Started")
        yield()
        Log.d(tag, "Task 2 Completed")
    }
}