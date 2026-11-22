package com.example.projectcattapperremake

sealed class Screen(val route: String) {
    object MainActivityScreen : Screen("main_activity_screen")
    object GameActivityScreen : Screen("game_activity_screen")
}