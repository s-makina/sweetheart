package com.example.sweetheart

import android.util.Log
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Locale

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

fun dateFormat(long: Long?): String {
    if (long == null) return ""
    val formatter = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    return formatter.format(long)
}