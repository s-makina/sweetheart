package com.example.sweetheart.ui.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.sweetheart.R
import com.example.sweetheart.navigation.Screen
import com.example.sweetheart.ui.component.LottieComponent
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.navigate(Screen.MainScreen.route)
    }

    Scaffold(modifier = Modifier) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues), contentAlignment = Alignment.Center) {
            LottieComponent(res = R.raw.cute_tiger)
        }
    }
}