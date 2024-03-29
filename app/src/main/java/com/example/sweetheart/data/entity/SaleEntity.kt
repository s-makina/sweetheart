package com.example.sweetheart.data.entity

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import org.mongodb.kbson.ObjectId

class SaleEntity: RealmObject {
    var _id: ObjectId = ObjectId()
    var amount: Double = 0.0
    var date: Long = System.currentTimeMillis()
    var customer: RealmList<Customer> = realmListOf()
}