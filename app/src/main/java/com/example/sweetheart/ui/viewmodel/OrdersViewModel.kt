package com.example.sweetheart.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sweetheart.data.repo.OrdersRepo
import com.example.sweetheart.ui.events.OrdersEvent
import com.example.sweetheart.ui.presentation.OrdersUiState
import com.example.sweetheart.ui.usecases.Validators
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrdersViewModel @Inject constructor(
    private val ordersRepo: OrdersRepo
): ViewModel(){
   private val validator = Validators()

    var state by mutableStateOf(OrdersUiState())

    fun event(event: OrdersEvent) {
        when (event) {
            is OrdersEvent.OnProductNameChange -> {
                state = state.copy(productName = event.name)
            }
            is OrdersEvent.OnOrderLocationChange -> {
                state = state.copy(location = event.location)
            }
            is OrdersEvent.OnAmountChange -> {
                state = state.copy(amount = event.amount)
            }
            is OrdersEvent.OnDescriptionChange -> {
                state = state.copy(description = event.description)
            }
            is OrdersEvent.OnSubmit -> {
                saveOrder()
            }
            is OrdersEvent.OnLoad -> {
                getOrders()
            }
        }
    }

    private fun getOrders() {
        viewModelScope.launch {
            ordersRepo.getOrders().collectLatest {
                state = state.copy(list = it)
            }
        }
    }

    private fun validate(): Boolean {
        val productNameResult = validator.validateRequired.execute(state.productName)
        val locationNameResult = validator.validateRequired.execute(state.location)
        val amountResult = validator.validateRequired.execute(state.amount)

        val hasErrors = listOf(
            productNameResult,
            locationNameResult,
            amountResult,
        ).any { !it.successful }

        state = state.copy(
            productNameError = productNameResult.errorMessage,
            locationError = locationNameResult.errorMessage,
            amountError = amountResult.errorMessage
        )
        return hasErrors
    }

    private fun saveOrder() {
        viewModelScope.launch(Dispatchers.IO) {
            if (validate()) return@launch
            ordersRepo.addNew(
                state.productName,
                state.location,
                state.amount,
                state.description
            )
        }
    }
}