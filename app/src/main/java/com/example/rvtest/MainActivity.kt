package com.example.rvtest

import android.content.Context
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    companion object{
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listOfList = listOf(
            listOf(0,1,2,3),
            listOf(4,5,6,7),
            listOf(8,9,10,11),
            listOf(12,13,14,15),
            listOf(16,17,18,19)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_main)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MainAdapter(listOfList)
            (layoutManager as? LinearLayoutManager)?.recycleChildrenOnDetach = true
        }

        startRepeatingJob(1000L)

    }

    private fun isKeyboardShown(): Boolean{
        return (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).isAcceptingText
    }

    private fun startRepeatingJob(timeInterval: Long): Job {
        return CoroutineScope(Dispatchers.Default).launch {
            while (NonCancellable.isActive) {
                // add your task here
                Log.d(TAG, "${isKeyboardShown()}")
                delay(timeInterval)
            }
        }
    }
}