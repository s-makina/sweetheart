package com.example.sweetheart.ui.pages

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sweetheart.R
import com.example.sweetheart.navigation.NavItem
import com.example.sweetheart.navigation.Screen
import com.example.sweetheart.ui.component.TopNav

@Composable
fun MainScreen() {
    val bottomNavController = rememberNavController()
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopNav()
        },
        bottomBar = {
            BottomNav(bottomNavController)
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = bottomNavController,
            startDestination = Screen.Dashboard.route
        ) {
            composable(Screen.Dashboard.route) {
               Dashboard()
            }
            composable(Screen.Debtors.route) {
                Debtors()
            }
            composable(Screen.Sales.route) {
                SalesScreen()
            }

            composable(Screen.Orders.route) {
                OrdersScreen()
            }
        }
    }
}

@Composable
fun BottomNav(bottomNavController: NavHostController) {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        NavItem(R.drawable.ic_dash, title = "Dashboard", Screen.Dashboard),
        NavItem(R.drawable.ic_shopping, title = "Sales", Screen.Sales),
        NavItem(R.drawable.ic_debtors, title = "Debtors", Screen.Debtors),
        NavItem(R.drawable.ic_orders, title = "Orders", Screen.Orders),
    )

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(painter = painterResource(id = item.res), contentDescription = item.title) },
                label = { Text(item.title) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    bottomNavController.navigate(item.screen.route) {
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}