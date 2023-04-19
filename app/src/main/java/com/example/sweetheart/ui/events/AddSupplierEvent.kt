package com.example.sweetheart.ui.events

sealed class AddSupplierEvent {
    class OnChangeName(val name: String): AddSupplierEvent()
    class OnDescription(val description: String): AddSupplierEvent()
    object OnSubmit: AddSupplierEvent()
}