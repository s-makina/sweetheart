package com.example.sweetheart.data.entity

import io.realm.kotlin.types.RealmObject
import org.mongodb.kbson.ObjectId

open class Customer: RealmObject {
    var _id: ObjectId = ObjectId()
    var name: String = ""
}