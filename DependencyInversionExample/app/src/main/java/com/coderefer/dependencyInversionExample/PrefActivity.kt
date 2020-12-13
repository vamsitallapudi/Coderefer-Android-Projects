package com.coderefer.dependencyInversionExample

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class PrefActivity : AppCompatActivity() {
    lateinit var viewModelFactory: PrefViewModelFactory
    private val btnDarkMode: Button = Button(this)
    private lateinit var viewmodel: PrefViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pref)
        viewModelFactory = PrefViewModelFactory((application as DIExampleApp).repository)
        viewmodel= ViewModelProvider(this, viewModelFactory).get(PrefViewModel::class.java)
        btnDarkMode.setOnClickListener {
            viewmodel.updateDarkMode(true)
        }
    }
}