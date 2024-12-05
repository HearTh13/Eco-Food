package com.prod.ecofood;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(){
    val navController = rememberNavController()
    Box(
        modifier = Modifier
            .background(Color.Black)
            .padding(WindowInsets.navigationBars.asPaddingValues())
    ){
        NavHost(navController = navController, startDestination = "Profile"){
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
                Profile(navController)
            }
        }
    }
}