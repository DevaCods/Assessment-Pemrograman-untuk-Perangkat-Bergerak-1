package com.devakisatya0003.assessment.navigation

sealed class Screen(val route: String) {

    object Home : Screen("home")

    object Quiz : Screen("quiz/{name}") {
        fun createRoute(name: String) = "quiz/$name"
    }

    object Result : Screen("result/{score}") {
        fun createRoute(score: Int) = "result/$score"
    }

    object About : Screen("about")
}