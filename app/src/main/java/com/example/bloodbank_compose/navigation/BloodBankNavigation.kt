package com.example.bloodbank_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bloodbank_compose.screens.AboutUsScreen
import com.example.bloodbank_compose.screens.BookingScreen
import com.example.bloodbank_compose.screens.AuthScreens.LoginScreen
import com.example.bloodbank_compose.screens.AuthScreens.SignupScreen

@Composable
fun BloodbankNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = BloodbankScreens.LoginScreen.name) {
        composable(BloodbankScreens.LoginScreen.name) { LoginScreen(navController) }
        composable(BloodbankScreens.SignupScreen.name) { SignupScreen(navController) }
        composable(BloodbankScreens.AboutUs.name) { AboutUsScreen(navController) }
        composable(BloodbankScreens.BookAppontment.name) { BookingScreen(navController) }

        // Add more destinations similarly.

    }
}

