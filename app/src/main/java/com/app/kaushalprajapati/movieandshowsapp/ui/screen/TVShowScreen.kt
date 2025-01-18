package com.app.kaushalprajapati.movieandshowsapp.ui.screen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.app.kaushalprajapati.movieandshowsapp.ui.MovieItem
import com.app.kaushalprajapati.movieandshowsapp.ui.ShimmerEffect
import com.app.kaushalprajapati.movieandshowsapp.viewmodel.WatchmodeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvShowScreen(viewModel: WatchmodeViewModel, navController: NavHostController) {
    val tvShows = viewModel.tvShows.value ?: emptyList() // Provide a default empty list if null
    val isLoading = viewModel.isLoading.value
    val errorMessage = viewModel.errorMessage.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("TV Shows", color = Color.Black)},
            )
                 },
        snackbarHost = {
            if (errorMessage != null) {
                Snackbar { Text(errorMessage) }
            }
        }
    ) { padding ->
        if (isLoading) {
            ShimmerEffect()
        } else {
            LazyColumn(modifier = Modifier.padding(padding)) {
                if (tvShows.isNotEmpty()) {
                    items(tvShows) { tvShow ->
                        MovieItem(title = tvShow) {
                            navController.navigate("details/${tvShow.id}/tv")
                        }
                    }
                } else {
                    item {
                        Text("No TV shows available")
                    }
                }
            }
        }
    }
}
