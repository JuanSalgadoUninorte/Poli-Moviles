package com.dev.poli.introuduccionajetpackcompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleRight
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Note
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Pantalla1: Destinations("pantalla1", "Preguntas", Icons.Filled.Home)
    object Pantalla2: Destinations("pantalla2/?newText={newText}", "Posts", Icons.Filled.Note) {
        fun createRoute(newText: String) = "pantalla2/?newText=$newText"
    }
    object Pantalla3: Destinations("pantalla3", "Navegador", Icons.Filled.ArrowCircleRight)
    object Pantalla4: Destinations("pantalla4", "Video", Icons.Filled.PlayArrow)
    object Pantalla5: Destinations("pantalla5", "Carousel", Icons.Filled.Image)
}
