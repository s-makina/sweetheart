package com.example.sweetheart

import android.util.Log

object Helper {
    fun log(msg: Any?) {
        Log.i("BETH", "$msg")
    }
}

fun String.stringToDouble() : Double {
    return try {
        this.toDouble()
    } catch (e: Exception) {
        0.0
    }
}