package com.dev.poli.introuduccionajetpackcompose.presentation.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.dev.poli.introuduccionajetpackcompose.navigation.Destinations
import com.dev.poli.introuduccionajetpackcompose.navigation.currentRoute

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    items: List<Destinations>
) {
    val currentRoute = currentRoute(navController)

    BottomNavigation(
        backgroundColor = Color(0.0f, 0.8f, 0.8f),
        contentColor = Color.White
    ) {
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(imageVector = screen.icon, contentDescription = screen.title) },
                label = { Text(screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                      navController.navigate(screen.route) {
                          popUpTo(navController.graph.findStartDestination().id){
                              saveState = true
                          }

                          launchSingleTop = true
                      }
                },
                alwaysShowLabel = false
            )
        }
    }
}