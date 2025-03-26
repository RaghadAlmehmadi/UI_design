package com.example.ui_design

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable("HomeScreen") { HomeScreen(navController) }
        composable("secondpage") { secondpage(navController) }
        composable("thirdScreen") { thirdScreen(navController) }
        composable("login") { Login(navController) }
        composable("signup") { signUp(navController) }
    }
}
