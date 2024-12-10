package com.prod.ecofood

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.prod.ecofood.ui.theme.EcoFoodTheme

@Composable
fun LogoScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC100))
            .clickable { navController.navigate("LogoToo") },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val faceImage = painterResource(R.drawable.image)
        Image(
            painter = faceImage,
            contentDescription = "image",
            modifier = Modifier
                .padding(40.dp)
                .size(200.dp)
        )
        Text(
            text = "Eat Good, Feel Good",
            fontSize = 20.sp
        )
        Column(
            modifier = Modifier
                .padding(40.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .height(2.dp)
            )
            Spacer(
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

// Fungsi preview harus berada di luar fungsi utama
@Preview(showBackground = true)
@Composable
fun LogoScreenPreview() {
    EcoFoodTheme {
        LogoScreen(rememberNavController())
    }
}
