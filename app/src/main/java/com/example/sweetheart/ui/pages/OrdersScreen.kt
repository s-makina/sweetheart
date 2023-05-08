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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sweetheart.ui.component.ListContainer
import com.example.sweetheart.ui.dialog.AddNewOrder

@Composable
fun OrdersScreen() {
    val addDialog = remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier,
        floatingActionButton = {
            FloatingActionButton(onClick = { addDialog.value = true}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            ListContainer(modifier = Modifier.padding(horizontal = 8.dp)) {
                items(10) {
                    OrderCard()
                }
                item{
                    Spacer(modifier = Modifier.height(70.dp))
                }
            }
        }
    }
    AddNewOrder(addDialog)
}

@Composable
fun OrderCard() {
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
                Text(text = "Orders", style = MaterialTheme.typography.titleMedium)
                Text(text = "Blantyre", style = MaterialTheme.typography.bodyMedium)
                Text(
                    text = "07 Apr 2023",
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            IconButton(onClick = {  }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            }
        }
    }
}

