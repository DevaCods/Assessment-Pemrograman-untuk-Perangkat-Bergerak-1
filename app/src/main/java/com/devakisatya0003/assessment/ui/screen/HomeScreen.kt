package com.devakisatya0003.assessment.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.devakisatya0003.assessment.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.devakisatya0003.assessment.navigation.Screen

@Composable
fun HomeScreen(navController: NavHostController) {

    var name by rememberSaveable { mutableStateOf("") }
    var category by rememberSaveable { mutableStateOf("") }
    var error by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(stringResource(R.string.input_name)) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(stringResource(R.string.choose_category))

        listOf("Hewan", "Umum").forEach {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = category == it,
                    onClick = { category = it }
                )
                Text(it)
            }
        }

        if (error) {
            Text(
                text = stringResource(R.string.error_input),
                color = Color.Red
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (name.isEmpty() || category.isEmpty()) {
                error = true
            } else {
                navController.navigate(Screen.Quiz.createRoute(name))
            }
        }) {
            Text(stringResource(R.string.btn_start))
        }

        Button(onClick = {
            navController.navigate("about")
        }) {
            Text(stringResource(R.string.btn_about))
        }
    }
}