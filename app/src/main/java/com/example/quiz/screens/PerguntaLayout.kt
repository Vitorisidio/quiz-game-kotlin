package com.example.quiz.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

// TELA DA PERGUNTA

@Composable
fun TelaPergunta(
    numeroPergunta: Int,
    totalPerguntas: Int,
    pergunta: String,
    respostas: List<String>,
    respostaCorreta: String,
    onProximaPergunta: () -> Unit,
    onRespostaRespondida: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {

    var respostaSelecionada by remember(numeroPergunta) {
        mutableStateOf<String?>(null)
    }

    var respostaEstaCerta by remember(numeroPergunta) {
        mutableStateOf(false)
    }

    // Espera 1 segundo depois que o usuário responde
    LaunchedEffect(respostaSelecionada) {
        if (respostaSelecionada != null) {
            delay(1000)
            onProximaPergunta()
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFED97CF))
            .padding(15.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Spacer(
                modifier = Modifier.height(40.dp)
            )

            quiz(
                modifier = Modifier.size(90.dp)
            )

            BoxContagem(
                numeroPergunta = numeroPergunta,
                totalPerguntas = totalPerguntas
            )

            CardPerguntas(
                pergunta = pergunta,
                respostas = respostas,
                respostaSelecionada = respostaSelecionada,
                respostaEstaCerta = respostaEstaCerta,
                onSelecionarResposta = { resposta ->

                    if (respostaSelecionada == null) {

                        respostaSelecionada = resposta

                        respostaEstaCerta = resposta == respostaCorreta

                        // Informa se a resposta está certa ou errada
                        onRespostaRespondida(respostaEstaCerta)
                    }
                }
            )
        }
    }
}


// CONTADOR DE PERGUNTAS

@Composable
fun BoxContagem(
    numeroPergunta: Int,
    totalPerguntas: Int,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .width(300.dp)
            .height(60.dp)
            .background(
                color = Color(0xFF8BD3A5),
                shape = RoundedCornerShape(20.dp)
            )
            .border(
                BorderStroke(3.dp, Color.Black),
                shape = RoundedCornerShape(20.dp)
            ),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = "Pergunta $numeroPergunta de $totalPerguntas",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            color = Color.Black
        )
    }
}


// CARD COM A PERGUNTA E AS RESPOSTAS

@Composable
fun CardPerguntas(
    pergunta: String,
    respostas: List<String>,
    respostaSelecionada: String?,
    respostaEstaCerta: Boolean,
    onSelecionarResposta: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .width(500.dp)
            .height(350.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(20.dp)
            )
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                text = pergunta,
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )

            respostas.forEach { resposta ->

                val corBotao = when {
                    resposta != respostaSelecionada -> Color.White
                    respostaEstaCerta -> Color(0xFF4CAF50)
                    else -> Color(0xFFF44336)
                }

                Button(
                    onClick = {
                        onSelecionarResposta(resposta)
                    },
                    enabled = respostaSelecionada == null,
                    modifier = Modifier
                        .width(350.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(13.dp),
                    contentPadding = PaddingValues(
                        start = 16.dp,
                        end = 16.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = corBotao,
                        disabledContainerColor = corBotao,
                        disabledContentColor = Color.Black
                    ),
                    border = BorderStroke(
                        width = 1.dp,
                        color = Color.Black
                    )
                ) {

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.CenterStart
                    ) {

                        Text(
                            text = resposta,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}