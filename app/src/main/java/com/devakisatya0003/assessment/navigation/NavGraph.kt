package com.devakisatya0003.assessment.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devakisatya0003.assessment.ui.screen.*

@Composable
fun SetupNavGraph() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {

        composable("home") {
            HomeScreen(navController)
        }

        composable("quiz/{name}") {
            val name = it.arguments?.getString("name") ?: ""
            QuizScreen(navController, name)
        }

        composable("result/{score}") {
            val score = it.arguments?.getString("score")?.toInt() ?: 0
            ResultScreen(navController, score)
        }

        composable("about") {
            AboutScreen(navController)
        }
    }
}