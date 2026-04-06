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

@Composable
fun ResultScreen(navController: NavHostController, score: Int) {

    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {

        Text(stringResource(R.string.label_score, score))

        Button(onClick = {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Score saya: $score")
            }
            context.startActivity(Intent.createChooser(intent, "Share"))
        }) {
            Text(stringResource(R.string.btn_share))
        }

        Button(onClick = {
            navController.navigate("quiz/test")
        }) {
            Text(stringResource(R.string.btn_repeat))
        }
    }
}