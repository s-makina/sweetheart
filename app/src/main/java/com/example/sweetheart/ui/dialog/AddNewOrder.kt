package com.example.sweetheart.ui.dialog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.sweetheart.dateFormat
import com.example.sweetheart.ui.component.ClickableTextField
import com.example.sweetheart.ui.component.DatePickerComponent
import com.example.sweetheart.ui.events.OrdersEvent
import com.example.sweetheart.ui.viewmodel.OrdersViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

@Composable
fun AddNewOrder(showDialog: MutableState<Boolean>, ordersViewModel: OrdersViewModel) {
    val state = ordersViewModel.state
    val showDatePicker = remember { mutableStateOf(false) }
    DatePickerComponent(showDatePicker, onSet = { date ->
        date?.let {
            ordersViewModel.event(OrdersEvent.OnDateChange(it))
        }
    })

    if (showDialog.value) {
        Dialog(onDismissRequest = { }) {
            Surface(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(8.dp)) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "New Order",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp)
                        )
                        IconButton(onClick = { showDialog.value = false }) {
                            Icon(imageVector = Icons.Default.Close, contentDescription = null)
                        }
                    }
                    val modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)

                    OutlinedTextField(
                        value = state.amount,
                        onValueChange = { ordersViewModel.event(OrdersEvent.OnAmountChange(it)) },
                        label = {
                            Text(text = "How much?")
                        },
                        modifier = modifier,
                        isError = state.amountError != null
                    )

                    OutlinedTextField(
                        value = state.location,
                        onValueChange = { ordersViewModel.event(OrdersEvent.OnOrderLocationChange(it)) },
                        label = {
                            Text(text = "Where are you ordering?")
                        },
                        modifier = modifier,
                        isError = state.locationError != null
                    )

                    ClickableTextField(onClick = { showDatePicker.value = true }) {
                        OutlinedTextField(
                            readOnly = true,
                            value = dateFormat(state.orderDate),
                            onValueChange = {},
                            modifier = modifier,
                            label = { Text(text = "Order Date") },
                            interactionSource = it
                        )
                    }

                    OutlinedTextField(
                        value = state.description,
                        onValueChange = { ordersViewModel.event(OrdersEvent.OnDescriptionChange(it)) },
                        label = { Text(text = "Description") },
                        minLines = 3,
                        maxLines = 4,
                        modifier = modifier
                    )

                    Button(
                        onClick = {
                            ordersViewModel.event(OrdersEvent.OnSubmit)
                            showDialog.value = false
                        }, modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.End)
                    ) {
                        Text(text = "Save")
                    }
                }
            }
        }
    }
}