package com.example.sweetheart.ui.pages

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Outbond
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sweetheart.R
import com.example.sweetheart.ui.component.ListContainer
import com.example.sweetheart.ui.component.SegmentedButton
import com.example.sweetheart.ui.dialog.AddNewDebtor
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Debtors() {
    val addDebtorDialog = remember{ mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { addDebtorDialog.value = true }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            val tabPadding = Modifier.padding(16.dp)
            val pagerState = rememberPagerState()
            val scope = rememberCoroutineScope()

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TabRow(selectedTabIndex = pagerState.currentPage) {
                    Tab(selected = pagerState.currentPage == 0, onClick = { scope.launch { pagerState.animateScrollToPage(0) } }) {
                        Row(verticalAlignment = Alignment.CenterVertically, modifier = tabPadding) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_alert),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Outstanding")
                        }
                    }
                    Tab(selected = pagerState.currentPage == 1, onClick = { scope.launch { pagerState.animateScrollToPage(1) } }) {
                        Row(verticalAlignment = Alignment.CenterVertically, modifier = tabPadding) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_check),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Settled")
                        }
                    }
                }
            }

            HorizontalPager(pageCount = 2, state = pagerState) { page ->
                if (page == 0) {
                    DebtorListComponent()
                } else {
                    DebtorListComponent()
                }
            }
        }
    }

    AddNewDebtor(addDebtorDialog)
}

@Composable
fun DebtorListComponent() {
    ListContainer(modifier = Modifier.padding(horizontal = 8.dp)) {
        item { Spacer(modifier = Modifier.height(8.dp)) }
        items(10) {
            DebtorItemCard()
        }
        item { Spacer(modifier = Modifier.height(70.dp)) }
    }
}

@Composable
fun DebtorItemCard() {
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
                Text(text = "Stella Kang'ombe", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "Total: K 20,000",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Paid: K 80,000 - Balance: K 5,000",
                    style = MaterialTheme.typography.bodyMedium
                )
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
