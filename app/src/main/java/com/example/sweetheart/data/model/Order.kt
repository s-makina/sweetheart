package com.example.sweetheart.data.model

import org.mongodb.kbson.ObjectId

data class Order(
    val id: ObjectId,
    val productName: String,
    val location: String,
    var amount: Double = 0.0,
    var date: Long = System.currentTimeMillis(),
    var description: String? = null
)