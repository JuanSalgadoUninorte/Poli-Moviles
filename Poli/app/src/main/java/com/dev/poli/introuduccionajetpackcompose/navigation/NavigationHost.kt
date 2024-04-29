package com.dev.poli.introuduccionajetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.dev.poli.introuduccionajetpackcompose.navigation.Destinations.Pantalla1
import com.dev.poli.introuduccionajetpackcompose.navigation.Destinations.Pantalla2
import com.dev.poli.introuduccionajetpackcompose.navigation.Destinations.Pantalla3
import com.dev.poli.introuduccionajetpackcompose.navigation.Destinations.Pantalla4
import com.dev.poli.introuduccionajetpackcompose.navigation.Destinations.Pantalla5
import com.dev.poli.introuduccionajetpackcompose.presentation.screens.Pantalla1
import com.dev.poli.introuduccionajetpackcompose.presentation.screens.Pantalla2
import com.dev.poli.introuduccionajetpackcompose.presentation.screens.Pantalla3
import com.dev.poli.introuduccionajetpackcompose.presentation.screens.Pantalla4
import com.dev.poli.introuduccionajetpackcompose.presentation.screens.Pantalla5

@Composable
fun NavigationHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Pantalla1.route) {
        composable(Pantalla1.route) {
            Pantalla1(
                navegarPantalla2 = { newText ->
                    navController.navigate(Pantalla2.createRoute(newText))
                }
            )
        }

        composable(
            Pantalla2.route,
            arguments = listOf(navArgument("newText"){ defaultValue = "Pantalla 2" })
        ) { navBackStackEntry ->
            var newText = navBackStackEntry.arguments?.getString("newText")
            requireNotNull(newText)
            Pantalla2(newText)
        }

        composable(Pantalla3.route) {
            Pantalla3()
        }

        composable(Pantalla4.route) {
            Pantalla4()
        }

        composable(Pantalla5.route) {
            Pantalla5()
        }
    }
}