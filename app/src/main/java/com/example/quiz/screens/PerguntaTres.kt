package com.example.quiz.screens

import androidx.compose.runtime.Composable

@Composable
fun PerguntaTres(
    onProximaPergunta: () -> Unit,
    onRespostaRespondida: (Boolean) -> Unit
) {
    TelaPergunta(
        numeroPergunta = 3,
        totalPerguntas = 3,
        pergunta = "Em um jogo, você ultrapassa quem está em segundo lugar. Em qual posição fica?",
        respostas = listOf(
            "Primeiro",
            "Segundo",
            "Terceiro",
            "Último"
        ),
        respostaCorreta = "Segundo",
        onProximaPergunta = onProximaPergunta,
        onRespostaRespondida = onRespostaRespondida
    )
}