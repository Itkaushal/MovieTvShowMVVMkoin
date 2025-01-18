package com.app.kaushalprajapati.movieandshowsapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.app.kaushalprajapati.movieandshowsapp.viewmodel.WatchmodeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(viewModel: WatchmodeViewModel, id: Int, type: String) {
    val item = if (type == "movie") {
        viewModel.movies.value.firstOrNull { it.id == id }
    } else {
        viewModel.tvShows.value.firstOrNull { it.id == id }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(item?.title ?: "Details") })
        }
    ) { padding ->
        if (item != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberImagePainter(item.poster?:"https://img.freepik.com/free-vector/gradient-no-photo-sign-design_23-2149288317.jpg?ga=GA1.1.1500534667.1700243594&semt=ais_hybrid"),
                    contentDescription = "Poster",
                    modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                item.title?.let { Text(it, style = MaterialTheme.typography.headlineMedium, textAlign = TextAlign.Center) }
                Spacer(modifier = Modifier.height(8.dp))
                Text("Year: ${item.year}", style = MaterialTheme.typography.titleLarge)

                Spacer(modifier = Modifier.height(8.dp))
                Text("Type: ${item.type}", style = MaterialTheme.typography.titleLarge)

                Spacer(modifier = Modifier.height(8.dp))
                Text("IMDB ID: ${item.imdb_id}", style = MaterialTheme.typography.titleLarge)

                Spacer(modifier = Modifier.height(8.dp))
                Text("TMDB ID: ${item.tmdb_id}", style = MaterialTheme.typography.titleLarge)

                Spacer(modifier = Modifier.height(16.dp))
                Text("Description: ${item.description}", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))
                item.description?.let { Text(it, textAlign = TextAlign.Justify) }

            }
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("No details available", style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}
