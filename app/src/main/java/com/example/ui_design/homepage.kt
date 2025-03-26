package com.example.ui_design


import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    var currentScreen by remember { mutableStateOf<String>("homeScreen") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF13152C)),
        contentAlignment = Alignment.Center
    ) {
        AnimatedContent(
            targetState = currentScreen,
            transitionSpec = { slideInHorizontally() with fadeOut() },
            content = { screen ->
                when (screen) {
                    "homeScreen" -> {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.skip),
                                color = Color.Gray,
                                modifier = Modifier
                                    .clickable {
                                        navController.navigate("signUp")
                                    }
                                    .align(Alignment.End)


                            )
                            Image(
                                painter = painterResource(id = R.drawable.home),
                                contentDescription = null,
                                modifier = Modifier.size(300.dp)
                            )
                            Text(
                                text = stringResource(id = R.string.numerous_free_courses),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                style = MaterialTheme.typography.headlineMedium
                            )
                            Text(
                                text = stringResource(id = R.string.free_courses_description),
                                fontSize = 16.sp,
                                color = Color.White,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Button(
                                onClick = { currentScreen = "secondpage" },
                                modifier = Modifier.padding(top = 16.dp)
                            ) {
                                Text(text = stringResource(id = R.string.Next))
                            }
                        }
                    }

                    "secondpage" -> secondpage(navController)
                }
            }
        )
    }
}


