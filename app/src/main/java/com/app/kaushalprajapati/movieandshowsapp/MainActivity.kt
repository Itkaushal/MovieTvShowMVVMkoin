package com.app.kaushalprajapati.movieandshowsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.app.kaushalprajapati.movieandshowsapp.navigation.AppNavHost
import com.app.kaushalprajapati.movieandshowsapp.ui.theme.MovieAndShowsAppTheme
import com.app.kaushalprajapati.movieandshowsapp.viewmodel.WatchmodeViewModel
import org.koin.androidx.compose.getViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAndShowsAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    val viewModel: WatchmodeViewModel = getViewModel()
                    val apiKey = "mXRPYrr0XIrhDjytcO0QDPkaQi7bECJL9F33XjTn"

                    AppNavHost(viewModel, apiKey)
                }
            }
        }
    }
}
