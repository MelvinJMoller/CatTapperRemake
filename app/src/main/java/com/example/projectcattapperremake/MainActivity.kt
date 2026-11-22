package com.example.projectcattapperremake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projectcattapperremake.ui.theme.ProjectCatTapperRemakeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProjectCatTapperRemakeTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun MainScreen(onStartGame: () -> Unit) {

    // Menu variables
    val menupicture = R.drawable.menu
    val btnWidth = 1000.dp
    val btnHeight = 1000.dp
    val btnX = 0.dp
    val btnY = 0.dp
    val btnColor = Color(0x00bc70ff)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            // Menu Background
            Image(
                painter = painterResource(id = menupicture),
                contentDescription = "Menu Background Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )

            // Start Game Button
            Button(
                onClick = {
                    onStartGame()
                },
                modifier = Modifier
                    .width(btnWidth)
                    .height(btnHeight)
                    .offset(btnX, btnY),
                colors = ButtonDefaults.buttonColors(
                    containerColor = btnColor
                ),
                shape = RectangleShape
            ) {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjectCatTapperRemakeTheme {

    }
}