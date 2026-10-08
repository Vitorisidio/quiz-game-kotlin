package com.example.quiz.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quiz.R

@Composable
fun TelaInicial(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF86D8F6))
            .padding(32.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Spacer(modifier = Modifier.height(60.dp))

            quiz(
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(45.dp))

            Text(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "QUIZATRON 3000",
                fontSize = 40.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(45.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .width(500.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF8DF59)
                ),
                border = BorderStroke(
                    width = 2.dp,
                    color = Color.Black
                )
            ) {
                Text(
                    text = "COMECAR!",
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun quiz(modifier: Modifier = Modifier) {

    Image(
        painter = painterResource(R.drawable.quiz),
        contentDescription = "quiz imagem",
        modifier = modifier
    )
}