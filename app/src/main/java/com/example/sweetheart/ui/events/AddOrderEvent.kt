package com.example.sweetheart.ui.events

import com.example.sweetheart.data.entity.SupplerEntity

sealed class AddOrderEvent {
    class OnSupplierChange(val supplier: SupplerEntity) : AddOrderEvent()
    class OnAmountChange(val amount: String) : AddOrderEvent()
    class OnDescription(val desc: String) : AddOrderEvent()
}