package com.example.sweetheart.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Dashboard : Screen("dashboard_screen")
    object Debtors : Screen("debtors_screen")
    object Sales : Screen("sales_screen")
    object MainScreen : Screen("main_screen")
}