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
import com.prod.ecofood.objects.Cart
import com.prod.ecofood.objects.Items

@Composable
fun Nav(){
    val navController = rememberNavController()
    val cart = Cart()
    val item = Items()
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(WindowInsets.navigationBars.asPaddingValues())
    ){
        NavHost(navController = navController, startDestination = "StartUp"){
            composable("StartUp") {
                LogoScreen(navController)
            }
            composable("LogoToo"){
                WasteLessScreen(navController)
            }
            composable("Home") {
                Home(navController, item, cart)
            }
            composable("Category") {
                CategoryPage(navController, item, cart)
            }
            composable("Cart") {
                Cart(navController, cart)
            }
            composable("Checkout") {
                Checkout(navController, cart)
            }
            composable("Profile") {
                Profile(navController)
            }
            composable("Payment"){
                ManualTransferScreen(navController, cart)
            }
            composable("Bought") {
                Bought(navController, cart)
            }
        }
    }
}