package com.example.composetest.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.R

@Composable
fun InstagramCard() {
    Card(
        modifier = Modifier
            .padding(8.dp),
        shape = RoundedCornerShape(
            topStart = 8.dp,
            topEnd = 8.dp
        ),
        contentColor = MaterialTheme.colors.onBackground,
        backgroundColor = MaterialTheme.colors.background,
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            InstagramCardHeader()
            Text(
                text = "Instagram",
                fontFamily = FontFamily.Cursive,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 14.dp)
            )
            Text(
                text = "#YoursToMake",
                fontSize = 10.sp,
            )
            Text(
                text = "www.instagram.com/Vp",
                fontSize = 10.sp
            )
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Cyan,
                    contentColor = MaterialTheme.colors.onBackground
                ),
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(text = "Follow")
            }
        }

    }
}

@Composable
fun InstagramCardHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.White)
                .padding(6.dp),
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentScale = ContentScale.FillWidth,
            contentDescription = ""
        )
        UserStatistics("Posts", "6,539")
        UserStatistics("Follower", "436M")
        UserStatistics("Following", "76M")
    }
}

@Composable
fun UserStatistics(
    title: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            fontSize = 22.sp,
            fontFamily = FontFamily.Cursive,
            text = value
        )
        Text(
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            text = title
        )
    }
}