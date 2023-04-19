package com.example.sweetheart.ui.events

import com.example.sweetheart.data.entity.Customer

sealed class AddSaleEvent {
    class OnCustomerChange(val customer: Customer): AddOrderEvent()
    class OnAmountChange(val amount: Int): AddOrderEvent()
}