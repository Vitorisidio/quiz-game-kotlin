package com.example.quiz.screens

import androidx.compose.runtime.Composable

@Composable
fun PerguntaDois(
    onProximaPergunta: () -> Unit,
    onRespostaRespondida: (Boolean) -> Unit
) {
    TelaPergunta(
        numeroPergunta = 2,
        totalPerguntas = 3,
        pergunta = "Se hoje é segunda-feira, que dia será daqui a 10 dias?",
        respostas = listOf(
            "Quarta-feira.",
            "Quinta-feira.",
            "Sexta-feira.",
            "Sábado."
        ),
        respostaCorreta = "Quinta-feira.",
        onProximaPergunta = onProximaPergunta,
        onRespostaRespondida = onRespostaRespondida
    )
}