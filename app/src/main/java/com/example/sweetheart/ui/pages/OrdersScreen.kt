package com.example.sweetheart.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sweetheart.data.model.Order
import com.example.sweetheart.ui.component.DatePickerComponent
import com.example.sweetheart.ui.component.ListContainer
import com.example.sweetheart.ui.dialog.AddNewOrder
import com.example.sweetheart.ui.events.OrdersEvent
import com.example.sweetheart.ui.viewmodel.OrdersViewModel

@Composable
fun OrdersScreen() {
    val ordersViewModel: OrdersViewModel = hiltViewModel()
    val state = ordersViewModel.state

    val addDialog = remember { mutableStateOf(false) }
    LaunchedEffect(key1 = true) {
        ordersViewModel.event(OrdersEvent.OnLoad)
    }

    Scaffold(
        modifier = Modifier,
        floatingActionButton = {
            FloatingActionButton(onClick = { addDialog.value = true }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            ListContainer(modifier = Modifier.padding(horizontal = 8.dp)) {
                items(state.list) { order ->
                    OrderCard(order)
                }

                item {
                    Spacer(modifier = Modifier.height(70.dp))
                }
            }
        }

    }
    AddNewOrder(addDialog, ordersViewModel)
}

@Composable
fun OrderCard(order: Order) {
    Card(modifier = Modifier.padding(bottom = 8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(text = order.productName, style = MaterialTheme.typography.titleMedium)
                Text(text = order.location, style = MaterialTheme.typography.bodyMedium)
                Text(
                    text = "07 Apr 2023",
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            }
        }
    }
}

