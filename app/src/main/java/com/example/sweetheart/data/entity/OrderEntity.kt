package com.example.sweetheart.data.entity

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import org.mongodb.kbson.ObjectId

class OrderEntity: RealmObject {
    var _id: ObjectId = ObjectId()
    var productName: String = ""
    var location: String = ""
    var amount: Double = 0.0
    var date: Long = System.currentTimeMillis()
    var description: String? = null
}