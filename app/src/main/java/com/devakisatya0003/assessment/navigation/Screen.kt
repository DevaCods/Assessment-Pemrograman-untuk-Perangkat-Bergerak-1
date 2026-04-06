package com.devakisatya0003.assessment.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Quiz: Screen("quiz")
    object Result: Screen("result")
    object About: Screen("about")
}