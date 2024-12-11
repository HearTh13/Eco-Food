package com.prod.ecofood

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.prod.ecofood.objects.Cart
import com.prod.ecofood.ui.theme.EcoFoodTheme

@Composable
fun Bought(navController: NavController, cart: Cart) {
    cart.clearCart()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable { navController.navigate("LogoToo") },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val image = painterResource(R.drawable.ic_check)
                Image(
                    painter = image,
                    contentDescription = "image"
                )
                Spacer(modifier = Modifier.padding(50.dp))
                Button(
                    onClick = { navController.navigate("Home") }
                ) {
                    Text(
                        text = "Back to Home",
                        fontSize = 30.sp
                    )
                }
            }
        }
    }
}

// Fungsi preview harus berada di luar fungsi utama
@Preview(showBackground = true)
@Composable
fun BoughtScreenPreview() {
    EcoFoodTheme {
        Bought(rememberNavController(), Cart())
    }
}
