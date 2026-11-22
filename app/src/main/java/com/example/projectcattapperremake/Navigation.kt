package com.example.projectcattapperremake

import androidx.compose.runtime.Composable
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainActivityScreen.route) {
        composable(route = Screen.MainActivityScreen.route) {
            MainScreen(onStartGame = {navController.navigate(Screen.GameActivityScreen.route)})
        }
        composable(Screen.GameActivityScreen.route) {
            GameScreen(
                onReturnToMenu = {navController.popBackStack()}
            )
        }
    }
}