package com.example.quiz.screens

import androidx.compose.runtime.Composable

@Composable
fun PerguntaUm(
    onProximaPergunta: () -> Unit,
    onRespostaRespondida: (Boolean) -> Unit
) {
    TelaPergunta(
        numeroPergunta = 1,
        totalPerguntas = 3,
        pergunta = "Qual é a capital da França?",
        respostas = listOf(
            "Londres",
            "Berlim",
            "Paris",
            "Madrid"
        ),
        respostaCorreta = "Paris",
        onProximaPergunta = onProximaPergunta,
        onRespostaRespondida = onRespostaRespondida
    )
}