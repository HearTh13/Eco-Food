package com.prod.ecofood;

import androidx.compose.runtime.Composable;
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "StartUp"){
        composable("StartUp") {

        }
        composable("Home") {

        }
        composable("Detail") {

        }
        composable("Category") {

        }
        composable("Cart") {

        }
        composable("Checkout") {

        }
        composable("Profile") {

        }
    }
}