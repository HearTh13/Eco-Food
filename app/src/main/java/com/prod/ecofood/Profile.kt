package com.prod.ecofood

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.prod.ecofood.ui.theme.EcoFoodTheme

@Composable
fun Profile(navController: NavController){
    Column {

    }
}

@Preview(showBackground = true)
@Composable
fun ReviewProfile(){
    EcoFoodTheme {
        Profile(rememberNavController())
    }
}