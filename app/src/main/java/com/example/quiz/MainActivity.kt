package com.example.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quiz.screens.PerguntaDois
import com.example.quiz.screens.PerguntaTres
import com.example.quiz.screens.PerguntaUm
import com.example.quiz.screens.TelaFinal
import com.example.quiz.screens.TelaInicial
import com.example.quiz.screens.TelaPergunta
import com.example.quiz.ui.theme.QUIZTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QUIZTheme {
                    val navController = rememberNavController()

                    var acertos by remember {
                        mutableStateOf(0)
                    }

                    Scaffold(
                        modifier = Modifier.fillMaxSize()
                    ) { innerPadding ->

                        NavHost(
                            navController = navController,
                            startDestination = "telaInicial",
                            modifier = Modifier.padding(innerPadding)
                        ) {

                            composable(route = "telaInicial") {
                                TelaInicial(
                                    onComecar = {
                                        acertos = 0
                                        navController.navigate("perguntaUm")
                                    }
                                )
                            }

                            composable(route = "perguntaUm") {
                                PerguntaUm(
                                    onProximaPergunta = {
                                        navController.navigate("perguntaDois")
                                    },
                                    onRespostaRespondida = { acertou ->
                                        if (acertou) {
                                            acertos++
                                        }
                                    }
                                )
                            }

                            composable(route = "perguntaDois") {
                                PerguntaDois(
                                    onProximaPergunta = {
                                        navController.navigate("perguntaTres")
                                    },
                                    onRespostaRespondida = { acertou ->
                                        if (acertou) {
                                            acertos++
                                        }
                                    }
                                )
                            }

                            composable(route = "perguntaTres") {
                                PerguntaTres(
                                    onProximaPergunta = {
                                        navController.navigate("telaFinal")
                                    },
                                    onRespostaRespondida = { acertou ->
                                        if (acertou) {
                                            acertos++
                                        }
                                    }
                                )
                            }

                            composable(route = "telaFinal") {
                                TelaFinal(
                                    acertos = acertos,
                                    totalPerguntas = 3,
                                    onJogarNovamente = {
                                        acertos = 0

                                        navController.navigate("perguntaUm") {
                                            popUpTo("telaInicial") {
                                                inclusive = false
                                            }
                                            launchSingleTop = true
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }