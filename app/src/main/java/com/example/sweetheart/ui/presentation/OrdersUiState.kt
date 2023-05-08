package com.example.sweetheart.ui.presentation

import com.example.sweetheart.data.model.Order

data class OrdersUiState(
    val list: List<Order> = emptyList(),
    val productName: String = "",
    val productNameError: String? = null,
    val amount: String = "",
    val amountError: String? = null,
    val location: String = "",
    val locationError: String? = null,
    val description: String = ""
)