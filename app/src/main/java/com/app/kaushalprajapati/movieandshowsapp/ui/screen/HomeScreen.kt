package com.app.kaushalprajapati.movieandshowsapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.kaushalprajapati.movieandshowsapp.ui.MovieItem
import com.app.kaushalprajapati.movieandshowsapp.ui.ShimmerEffect
import com.app.kaushalprajapati.movieandshowsapp.viewmodel.WatchmodeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: WatchmodeViewModel, apiKey: String, navController: NavHostController) {
    val movies = viewModel.movies.value
    val isLoading = viewModel.isLoading.value
    val errorMessage = viewModel.errorMessage.value

    LaunchedEffect(Unit) {
        viewModel.fetchData(apiKey)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Watchmode App") })
        },
        snackbarHost = {
            if (errorMessage != null) {
                Snackbar { Text(errorMessage) }
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(onClick = { navController.navigate("home") },
                    modifier = Modifier
                        .padding(10.dp)
                        .width(120.dp)
                        .align(Alignment.CenterVertically)
                        .padding(start = 20.dp)
                        .background(color = Color.Black, shape = RoundedCornerShape(30.dp))

                ) {
                    Text("Movies", color = Color.Red, letterSpacing = 1.sp, fontSize = 16.sp)
                }


                TextButton(onClick = { navController.navigate("tv_shows") },
                    modifier = Modifier
                        .padding(10.dp)
                        .width(120.dp)
                        .align(Alignment.CenterVertically)
                        .padding(end = 20.dp)
                        .background(color = Color.Black, shape = RoundedCornerShape(30.dp))) {
                    Text("TV Shows", color = Color.Red, fontSize = 16.sp, letterSpacing = 1.sp)
                }
            }

            if (isLoading) {
                ShimmerEffect()
            } else {
                LazyColumn {
                    items(movies) { movie ->
                        MovieItem(title = movie) {
                            navController.navigate("details/${movie.id}/movie")
                        }
                    }
                }
            }
        }
    }
}

