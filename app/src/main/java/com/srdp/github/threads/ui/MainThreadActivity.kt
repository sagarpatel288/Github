package com.srdp.github.threads.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.srdp.github.R

class MainThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_thread)
    }

    class ThreadExample: Thread() {

        override fun run() {
           for (i in 0..10) {
               
            }
        }
    }
}