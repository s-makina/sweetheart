package com.example.sweetheart.data

import com.example.sweetheart.data.entity.OrderEntity
import com.example.sweetheart.data.model.Order

fun OrderEntity.toOrder(): Order {
    return Order(
        id = _id,
        productName = productName,
        location = location,
        amount = amount
    )
}