package com.coderefer.servicesexample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.compose.setContent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyName()

        }
        startService(Intent(this, MyService::class.java))
    }


    @Preview
    @Composable
    fun MyName() {
        Text("Hello Vamsi, from Composable!")
    }
}