package com.dev.poli.introuduccionajetpackcompose.presentation.screens

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.poli.introuduccionajetpackcompose.presentation.components.VideoPlayer
import com.dev.poli.introuduccionajetpackcompose.ui.theme.XMLViewsInComposeTheme

@Composable
fun Pantalla4(){
    val videoUri = Uri.parse("android.resource://com.dev.poli.introuduccionajetpackcompose/raw/preguntas")
    XMLViewsInComposeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VideoPlayer(videoUri=videoUri)
        }
    }
}