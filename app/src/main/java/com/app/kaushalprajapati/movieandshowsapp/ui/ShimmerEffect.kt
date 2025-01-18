package com.app.kaushalprajapati.movieandshowsapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun ShimmerEffect() {
    Column(modifier = Modifier.fillMaxSize().shimmer()) {
        repeat(5) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color.LightGray),
            ) {}
        }
    }
}
