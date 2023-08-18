package com.example.sweetheart.ui.events

sealed class OrdersEvent {
    class OnProductNameChange(val name: String): OrdersEvent()
    class OnAmountChange(val amount: String): OrdersEvent()
    class OnOrderLocationChange(val location: String): OrdersEvent()
    class OnDescriptionChange(val description: String): OrdersEvent()
    class OnDateChange(val date: Long) : OrdersEvent()
    object OnSubmit: OrdersEvent()
    object OnLoad: OrdersEvent()
}