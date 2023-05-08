package com.example.sweetheart.data.repo

import com.example.sweetheart.Helper.log
import com.example.sweetheart.data.entity.OrderEntity
import com.example.sweetheart.data.model.Order
import com.example.sweetheart.data.toOrder
import com.example.sweetheart.stringToDouble
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class OrdersRepo(private val realm: Realm) {

    suspend fun addNew(productName: String, location: String, amount: String, description: String) {
        log("Product Name")
        realm.write {
            this.copyToRealm((OrderEntity().apply {
                this.productName = productName
                this.location = location
                this.amount = amount.stringToDouble()
                this.description = description
            }))
        }
    }

    fun getOrders(): Flow<List<Order>>{
         return realm.query<OrderEntity>().asFlow().map { it.list.map { it.toOrder() } }
    }

}