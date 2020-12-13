package com.coderefer.dependencyInversionExample

import android.content.Context

class PrefLocalDataSourceImpl(val context: Context) : PrefRepo {
    override fun updateDarkMode(enabled: Boolean) {
        val sharedPreferences = context.getSharedPreferences("darkModePref", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("darkMode", true)
        editor.apply()
    }
}