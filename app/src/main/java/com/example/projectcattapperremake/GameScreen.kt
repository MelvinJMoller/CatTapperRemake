package com.example.projectcattapperremake

import android.media.MediaPlayer
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.projectcattapperremake.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember


@Composable
            fun GameScreen(onReturnToMenu: () -> Unit) {

                // Set up variables here:
                var gameBtnColor = Color(0x00ffffff)
                var gameBtnStroke = 1.dp
                var gameBtnStrokeColor by remember { mutableStateOf(Color(0xff000000)) }
                var btnValue = 0
                var currentLevel = 0

                var gameBtnText by remember { mutableStateOf("START THE GAME") }
                var gameBtnWidth by remember { mutableStateOf(0.5f) }
                var gameBtnHeight by remember { mutableStateOf(0.3f) }
                var gameBtnX by remember { mutableStateOf(0.25f) }
                var gameBtnY by remember { mutableStateOf(0.4f) }

                var emptyBg by remember { mutableStateOf(R.drawable.emptybg) }
                val winBg by remember { mutableStateOf(R.drawable.emptybg) }
                val level1 by remember { mutableStateOf(R.drawable.easylevel) }
                val level2 by remember { mutableStateOf(R.drawable.freakyapartment) }
                val level3 by remember { mutableStateOf(R.drawable.wiredweirdworld) }
                val level4 by remember { mutableStateOf(R.drawable.kingsrock) }
                val level5 by remember { mutableStateOf(R.drawable.facemountain) }
                val level6 by remember { mutableStateOf(R.drawable.stickmanparadise) }
                val level7 by remember { mutableStateOf(R.drawable.ticcattoe) }

                var time by remember { mutableStateOf(0L) }
                var timeRunning by remember { mutableStateOf(false) }

                var gameOver by remember { mutableStateOf(false) }

                val context = LocalContext.current
                val ambianceMusic = remember { MediaPlayer.create(context, R.raw.heartofnowheremacleod) }
                val gameMusic = remember { MediaPlayer.create(context, R.raw.thinkingmusickmacleod) }
                val catSE1 = remember { MediaPlayer.create(context, R.raw.catsound1) }
                val catSE2 = remember { MediaPlayer.create(context, R.raw.catsound2) }
                val catSE3 = remember { MediaPlayer.create(context, R.raw.catsound3) }
                val catSE4 = remember { MediaPlayer.create(context, R.raw.catsound4) }
                val catSE5 = remember { MediaPlayer.create(context, R.raw.catsound5) }

                DisposableEffect(Unit) {
                    ambianceMusic.isLooping = true
                    ambianceMusic.start()

                    onDispose {
                        ambianceMusic.release()
                        gameMusic.release()
                        catSE1.release()
                        catSE2.release()
                        catSE3.release()
                        catSE4.release()
                        catSE5.release()
                    }
                }

                // Chronotimer
                LaunchedEffect(timeRunning) {
                    while (timeRunning) {
                        delay(1000L)
                        time++
                    }
                }

                // Function to load the correct background picture and move the hitbox
                fun LevelLoad() {
                    println("Current level:")
                    println(currentLevel)

                    if(currentLevel == 1) {
                        emptyBg = level1
                        gameBtnWidth = 0.55f
                        gameBtnHeight = 0.275f
                        gameBtnX = 0.28f
                        gameBtnY = 0.37f
                    }
                    else if(currentLevel == 2) {
                        emptyBg = level2
                        gameBtnWidth = 0.10f
                        gameBtnHeight = 0.0375f
                        gameBtnX = 0.86f
                        gameBtnY = 0.98f
                    }
                    else if(currentLevel == 3) {
                        emptyBg = level3
                        gameBtnWidth = 0.40f
                        gameBtnHeight = 0.25f
                        gameBtnX = 0.10f
                        gameBtnY = 0.49f
                    }
                    else if(currentLevel == 4) {
                        emptyBg = level4
                        gameBtnWidth = 0.075f
                        gameBtnHeight = 0.025f
                        gameBtnX = 0.2875f
                        gameBtnY = 0.55f
                    }
                    else if(currentLevel == 5) {
                        emptyBg = level5
                        gameBtnWidth = 0.0875f
                        gameBtnHeight = 0.03125f
                        gameBtnX = 0.70f
                        gameBtnY = 0.3375f
                    }
                    else if(currentLevel == 6) {
                        emptyBg = level6
                        gameBtnWidth = 0.25f
                        gameBtnHeight = 0.2f
                        gameBtnX = 0.7f
                        gameBtnY = 0.4f
                    }
                    else if(currentLevel == 7) {
                        emptyBg = level7
                        gameBtnWidth = 0.15f
                        gameBtnHeight = 0.05f
                        gameBtnX = 0.5f
                        gameBtnY = 0.7f
                    }
                    // Here I can add more levels!
                }

                // Function to determine which randomized sound effect is going to play
                fun catSoundEffect() {
                    var randomCatSound = (1..5).random()

                    if(randomCatSound == 1) {
                        if(!catSE1.isPlaying) {
                            catSE1.isLooping = false
                            catSE1.start()
                        }
                    } else if(randomCatSound == 2) {
                        if(!catSE2.isPlaying) {
                            catSE2.isLooping = false
                            catSE2.start()
                        }
                    } else if(randomCatSound == 3) {
                        if(!catSE3.isPlaying) {
                            catSE3.isLooping = false
                            catSE3.start()
                        }
                    } else if(randomCatSound == 4) {
                        if(!catSE4.isPlaying) {
                            catSE4.isLooping = false
                            catSE4.start()
                        }
                    } else if(randomCatSound == 5) {
                        if(!catSE5.isPlaying) {
                            catSE5.isLooping = false
                            catSE5.start()
                        }
                    }
                }

                // Function to run when game ends
                fun GameEnd() {
                    println("GAME HAS ENDED!")
                    gameOver = true
                    emptyBg = winBg
                    timeRunning = false
                    //Place the Button in around the middle
                    gameBtnWidth = 0.3f
                    gameBtnHeight = 0.1f
                    gameBtnX = 0.3f
                    gameBtnY = 0.5f
                    gameBtnText = "MENU"
                    gameBtnStrokeColor = Color(0xff000000)
                    // Stops the background music
                    if(gameMusic.isPlaying) {
                        gameMusic.pause()
                        gameMusic.seekTo(0)
                    }

                    if(!ambianceMusic.isPlaying) {
                        ambianceMusic.isLooping = true
                        ambianceMusic.start()
                    }
                }

                // Game Function
                fun GameStart() {
                    btnValue++
                    println("Button Value is:")
                    println(btnValue)
                    gameBtnText = " "
                    gameBtnStrokeColor = Color(0x00000000)

                    // Stop the ambiance
                    if(ambianceMusic.isPlaying) {
                        ambianceMusic.pause()
                        ambianceMusic.seekTo(0)
                    }

                    // Start the background music
                    if(!gameMusic.isPlaying) {
                        gameMusic.isLooping = true
                        gameMusic.start()
                    }

                    // Play the sound effect function
                    if(!gameOver) {
                        catSoundEffect()
                    }

                    // Randomize Level
                    var randomNumber = (1..7).random()
                    println("RandomLv:")
                    println(randomNumber)
                    // If its the same level as last time, randomize it again
                    if(randomNumber == currentLevel) {
                        println("SAME LEVEL!")
                        randomNumber = (1..7).random()
                    }
                    currentLevel = randomNumber
                    LevelLoad()

                    if(!timeRunning) {
                        timeRunning = true
                    }
                }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Parent Box
                    BoxWithConstraints(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        // Background image
                        Image(
                            painter = painterResource(id = emptyBg),
                            contentDescription = "Game Background",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.fillMaxSize()
                        )

                        // Game button
                        Button(
                            onClick = {
                                if (gameOver) {
                                    onReturnToMenu()
                                }

                                if (btnValue > 9) {
                                    GameEnd()
                                } else {
                                    GameStart()
                                }
                            },
                            modifier = Modifier
                                .width(maxWidth * gameBtnWidth)
                                .height(maxHeight * gameBtnHeight)
                                .offset(
                                    x = maxWidth * gameBtnX,
                                    y = maxHeight * gameBtnY
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = gameBtnColor,
                                contentColor = gameBtnStrokeColor
                            ),
                            border = BorderStroke(gameBtnStroke, gameBtnStrokeColor),
                            shape = RectangleShape
                        ) {
                            Text(gameBtnText)
                        }

                        if (gameOver) {
                            Text(
                                text = "Congratulations! \nYour time was: ${time / 60}:${(time % 60).toString().padStart(2, '0')}",
                                modifier = Modifier.offset(25.dp, 40.dp),
                                fontSize = 32.sp
                            )
                        }
                    }
                }
            }
