package com.coderefer.dependencyInversionExample
import androidx.lifecycle.ViewModel

class PrefViewModel(private val prefRepo: PrefRepo): ViewModel() {
    fun updateDarkMode(enabled: Boolean) {
        prefRepo.updateDarkMode(enabled)
    }
}