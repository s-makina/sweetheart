package com.example.sweetheart.data.entity

import io.realm.kotlin.types.RealmObject
import org.mongodb.kbson.ObjectId

open class SupplerEntity: RealmObject {
    var _id: ObjectId = ObjectId()
    var name: String = ""
    var description: String? = null
}