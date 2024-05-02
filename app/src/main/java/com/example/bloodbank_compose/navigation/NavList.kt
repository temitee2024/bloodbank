package com.example.bloodbank_compose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

data class NavList(val title: String,
                   val selectedIcon: ImageVector,
                   val unselectedIcon: ImageVector,
                   val route: String = "")



val listOfNavItems : List<NavList> = listOf(
    NavList(
        title = "Book",
        selectedIcon = Icons.Filled.DateRange,
        unselectedIcon = Icons.Outlined.DateRange,
        route = BloodbankScreens.BookAppontment.name
    ),
    NavList(
        title = "About us",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        route = BloodbankScreens.AboutUs.name
    ),

)