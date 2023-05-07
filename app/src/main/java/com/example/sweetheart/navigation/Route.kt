package com.example.sweetheart.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sweetheart.ui.pages.Dashboard
import com.example.sweetheart.ui.pages.MainScreen
import com.example.sweetheart.ui.pages.SplashScreen

@Composable
fun Routing() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController)
        }

        composable(route = Screen.MainScreen.route) {
            MainScreen()
        }
    }
}