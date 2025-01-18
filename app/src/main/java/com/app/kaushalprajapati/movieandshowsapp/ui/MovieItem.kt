package com.app.kaushalprajapati.movieandshowsapp.ui

import android.graphics.Paint.Align
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.app.kaushalprajapati.movieandshowsapp.model.Title

@Composable
fun MovieItem(title: Title, onClick: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)
        .clickable { onClick() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Spacer(modifier = Modifier.height(10.dp))
        Card (modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .align(Alignment.CenterHorizontally)
            .background(color = Color.White)
            .clip(shape = RoundedCornerShape(30.dp))
            .padding(10.dp),
        ){

            Text(text = "tmdb id: "+title.tmdb_id.toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                modifier = Modifier.align(Alignment.End)
                    .background(color = Color.Black.copy(alpha = 5f), shape = RoundedCornerShape(topEnd = 25.dp, bottomStart = 25.dp))
                    .padding(5.dp))

            Image(
                painter = rememberImagePainter(
                    title.poster?: "https://img.freepik.com/free-vector/gradient-no-photo-sign-design_23-2149288317.jpg?ga=GA1.1.1500534667.1700243594&semt=ais_hybrid"
                ),
                contentDescription = title.title,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(180.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(5.dp)
                    .background(color = Color.DarkGray, shape = RoundedCornerShape(100))

            )

            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()) {

                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "ID: "+title.id.toString(), fontSize = 16.sp,
                    color = Color.Red.copy(alpha = 0.7f),
                    modifier = Modifier
                        .background(
                            color = Color.Cyan.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(30.dp)
                        )
                        .padding(5.dp))

                Spacer(modifier = Modifier.width(5.dp))
                Text(text = title.title.toString(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W700,
                    color = Color.Black)
            }


            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically) {

                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "type: "+title.type.toString(),
                    fontSize = 16.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "imbd id: "+title.imdb_id.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray)
            }

        }

    }
}
