package com.example.sweetheart.ui.events

sealed class AddCustomerEvent {
    class OnNameChange(val name: String): AddCustomerEvent()
    object OnSubmit: AddCustomerEvent()
}