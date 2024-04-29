package com.dev.poli.introuduccionajetpackcompose.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dev.leonardom.introuduccionajetpackcompose.R
import kotlinx.coroutines.delay


//@OptIn(ExperimentalPagerApi::class)
//@Composable
//fun Pantalla5() {
//    val pagerState = rememberPagerState(initialPage = 2)
//    val sliderList = listOf(
//        "https://picsum.photos/id/0/200/300",
//        "https://picsum.photos/id/8/200/300",
//        "https://picsum.photos/id/1/200/300",
//        "https://picsum.photos/id/48/200/300",
//        "https://picsum.photos/id/60/200/300",
//        "https://picsum.photos/id/119/200/300",
//        "https://picsum.photos/id/180/200/300",
//        "https://picsum.photos/id/201/200/300",
//    )
//    val scope = rememberCoroutineScope()
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            IconButton(
//                enabled = pagerState.currentPage > 0,
//                onClick = {
//                    scope.launch {
//                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
//                    }
//                }) {
//                Icon(Icons.Default.ArrowLeft, null)
//            }
//            HorizontalPager(
//                count = sliderList.size,
//                state = pagerState,
//                contentPadding = PaddingValues(horizontal = 65.dp),
//                modifier = Modifier
//                    .height(350.dp)
//                    .weight(1f)
//            ) { page ->
//                Card(
//                    shape = RoundedCornerShape(10.dp),
//                    modifier = Modifier.graphicsLayer {
//                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
//                        lerp(
//                            start = 0.50f,
//                            stop = 1f,
//                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
//                        )
//                            .also { scale ->
//                                scaleX = scale
//                                scaleY = scale
//                            }
//                        alpha = lerp(
//                            start = 0.50f,
//                            stop = 1f,
//                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
//                        )
//                    }
//                ) {
//                    AsyncImage(
//                        model = ImageRequest.Builder(LocalContext.current)
//                            .data(sliderList[page])
//                            .crossfade(true)
//                            .scale(Scale.FILL)
//                            .build(), contentDescription = null,
//                        placeholder = painterResource(id = R.drawable.oops),
//                        error = painterResource(id = R.drawable.error)
//                    )
//                }
//
//            }
//            IconButton(
//                enabled = pagerState.currentPage < pagerState.currentPage - 1,
//                onClick = {
//                    scope.launch {
//                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
//                    }
//                }) {
//                Icon(Icons.Default.ArrowRight, null)
//            }
//        }
//        Row(
//            Modifier
//                .height(50.dp)
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.Center
//        ) {
//            repeat(sliderList.size){
//                    it->
//                var color = if (pagerState.currentPage==it) Color.DarkGray else Color.LightGray
//                Box(
//                    modifier = Modifier
//                        .padding(2.dp)
//                        .clip(CircleShape)
//                        .size(20.dp)
//                        .background(color)
//                        .clickable {
//                            scope.launch {
//                                pagerState.animateScrollToPage(it)
//                            }
//                        }
//                ){}
//            }
//        }
//    }

//}
@Composable
fun Pantalla5() {
    // Lista de imágenes de ejemplo (reemplaza estas imágenes con las tuyas)
    val images = listOf(
        R.drawable.imagen1,
        R.drawable.imagen2,
        R.drawable.imagen3,
        R.drawable.imagen1,
        R.drawable.imagen2,
        R.drawable.imagen3,
        R.drawable.imagen1,
        R.drawable.imagen2,
        R.drawable.imagen3
    )
// Estado para mantener el índice actual de la imagen visible
    var currentIndex by remember { mutableStateOf(0) }

    // Estado para el LazyListState
    val lazyListState = rememberLazyListState()

    // La corutina para el desplazamiento automático
    LaunchedEffect(Unit) {
        while (true) {
            delay(5000) // Espera 5 segundos
            currentIndex = (currentIndex + 1) % images.size // Cambia al siguiente índice
            lazyListState.animateScrollToItem(currentIndex)
        }
    }

    // Columna que contiene el Carousel de imágenes
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 16.dp)
    ) {
        // Imagen principal
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(color = Color.LightGray)
        ) {
            Image(
                painter = painterResource(id = images[currentIndex]),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        // Lista de miniaturas de imágenes
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(vertical = 8.dp),
            state = lazyListState,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            itemsIndexed(images) { index, image ->
                val isSelected = index == currentIndex
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(if (isSelected) 100.dp else 80.dp)
                        .padding(horizontal = 4.dp)
                        .background(if (isSelected) Color.Blue else Color.Gray, shape = CircleShape)
                        .clickable { currentIndex = index },
                    contentScale = ContentScale.Crop
                )
            }
        }

        // Lista de puntos horizontales para indicar la posición actual
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            for (i in images.indices) {
                val color = if (i == currentIndex) Color.Blue else Color.Gray
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(12.dp)
                        .background(color = color, shape = CircleShape)
                        .clickable { currentIndex = i }
                ) {
                    if (i == currentIndex) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Previous",
                            modifier = Modifier.size(12.dp)
                        )
                    }
                }
            }
        }

        // Botones de navegación
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { currentIndex = (currentIndex - 1).coerceIn(images.indices) },
                enabled = currentIndex > 0,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = if (currentIndex > 0) Color.Black else Color.Gray
                ),
                modifier = Modifier
                    .padding(end = 4.dp)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Previous")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = { currentIndex = (currentIndex + 1).coerceIn(images.indices) },
                enabled = currentIndex < images.size - 1,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = if (currentIndex < images.size - 1) Color.Black else Color.Gray
                ),
                modifier = Modifier
                    .padding(start = 4.dp)
            ) {
                Icon(Icons.Default.ArrowForward, contentDescription = "Next")
            }
        }
    }
}
