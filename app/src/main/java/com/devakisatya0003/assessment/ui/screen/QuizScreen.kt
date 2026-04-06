package com.devakisatya0003.assessment.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.devakisatya0003.assessment.R
import com.devakisatya0003.assessment.navigation.Screen

@Composable
fun QuizScreen(navController: NavHostController, name: String) {

    var index by rememberSaveable { mutableIntStateOf(0) }
    var score by rememberSaveable { mutableIntStateOf(0) }
    var selected by rememberSaveable { mutableIntStateOf(-1) }

    if (index >= questionList.size) return

    val question = questionList[index]

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Halo $name")

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            stringResource(
                R.string.question_number,
                index + 1,
                questionList.size
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(question.imageRes),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(question.question)

        question.options.forEachIndexed { i, option ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selected == i,
                    onClick = { selected = i }
                )
                Text(option)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {

                if (selected == question.answer) {
                    score += 10
                }

                if (index < questionList.size - 1) {
                    index++
                    selected = -1
                } else {
                    navController.navigate(Screen.Result.createRoute(score))
                }

            },
            enabled = selected != -1
        ) {
            Text(stringResource(R.string.btn_next))
        }
    }
}