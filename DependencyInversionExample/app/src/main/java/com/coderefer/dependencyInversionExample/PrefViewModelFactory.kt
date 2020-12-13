package com.coderefer.dependencyInversionExample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PrefViewModelFactory(private val repo: PrefRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PrefViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return PrefViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}