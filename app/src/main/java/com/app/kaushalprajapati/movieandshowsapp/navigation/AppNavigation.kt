package com.app.kaushalprajapati.movieandshowsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.kaushalprajapati.movieandshowsapp.ui.screen.DetailScreen
import com.app.kaushalprajapati.movieandshowsapp.ui.screen.HomeScreen
import com.app.kaushalprajapati.movieandshowsapp.ui.screen.TvShowScreen
import com.app.kaushalprajapati.movieandshowsapp.viewmodel.WatchmodeViewModel

@Composable
fun AppNavHost(viewModel: WatchmodeViewModel, apiKey: String) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(viewModel, apiKey, navController)
        }
        composable("tv_shows") {
            TvShowScreen(viewModel, navController)
        }
        composable("details/{id}/{type}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            val type = backStackEntry.arguments?.getString("type")
            if (id != null && type != null) {
                DetailScreen(viewModel, id, type)
            }
        }
    }
}
