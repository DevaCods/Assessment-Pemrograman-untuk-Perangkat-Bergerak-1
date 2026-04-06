package com.devakisatya0003.assessment.ui.screen

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.devakisatya0003.assessment.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devakisatya0003.assessment.navigation.Screen

@Composable
fun ResultScreen(navController: NavHostController, score: Int) {

    val context = LocalContext.current

    val resultText = when {
        score >= 80 -> stringResource(R.string.result_pintar)
        score >= 50 -> stringResource(R.string.result_lumayan)
        else -> stringResource(R.string.result_belajar)
    }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text(stringResource(R.string.label_score, score))

        Spacer(modifier = Modifier.height(8.dp))

        Text(resultText)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Score saya: $score")
            }
            context.startActivity(Intent.createChooser(intent, "Share"))
        }) {
            Text(stringResource(R.string.btn_share))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            navController.navigate(Screen.Quiz.createRoute("test")) {
                popUpTo(Screen.Home.route)
            }
        }) {
            Text(stringResource(R.string.btn_repeat))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            navController.navigate(Screen.Home.route) {
                popUpTo(Screen.Home.route) {
                    inclusive = true
                }
            }
        }) {
            Text(stringResource(R.string.btn_return))
        }
    }
}