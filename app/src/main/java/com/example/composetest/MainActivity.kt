package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.composetest.ui.MainScreen
import com.example.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}


//@Preview
//@Composable
//fun PreviewCardDark() {
//    ComposeTestTheme(
//        darkTheme = true
//    ) {
//        PostCard()
//    }
//}
//
//@Preview
//@Composable
//fun PreviewCardLight() {
//    ComposeTestTheme(
//        darkTheme = false
//    ) {
//        PostCard()
//    }
//}