package com.devakisatya0003.assessment.model

data class Question(
    val question: String,
    val imageRes: Int,
    val options: List<String>,
    val answer: Int
)