package com.example.sweetheart.ui.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun AddNewSale(showDialog: MutableState<Boolean>) {
    if (showDialog.value) {
        Dialog(onDismissRequest = { /*TODO*/ }) {
            Surface(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(8.dp)) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "New Sale",
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
                        value = "",
                        onValueChange = {},
                        label = {
                            Text(text = "Amount")
                        },
                        modifier = modifier
                    )

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = {
                            Text(text = "Order")
                        },
                        modifier = modifier
                    )

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text(text = "Description") },
                        minLines = 3,
                        maxLines = 4,
                        modifier = modifier
                    )

                    Button(
                        onClick = { /*TODO*/ }, modifier = Modifier
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