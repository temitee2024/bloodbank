package com.example.bloodbank_compose.navigation

enum class BloodbankScreens {
    LoginScreen,
    SignupScreen,
    BookAppontment,
    AboutUs;
    companion object {
        fun fromRoute(route: String?): BloodbankScreens =
            when (route?.substringBefore("/")){
                LoginScreen.name -> LoginScreen
                SignupScreen.name -> SignupScreen
                BookAppontment.name -> BookAppontment
                AboutUs.name -> AboutUs
                null -> LoginScreen
                else -> throw IllegalArgumentException("Route $route is not found" )
            }
    }


}