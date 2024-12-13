package com.prod.ecofood

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prod.ecofood.ui.theme.EcoFoodTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun WasteLessScreen(navConroller: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC100)),
        verticalArrangement = Arrangement.SpaceBetween, // Distribute elements evenly
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image Section
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val recycleImage = painterResource(id = R.drawable.recycle)
            Image(
                painter = recycleImage,
                contentDescription = "Recycle Icon",
                modifier = Modifier
                    .padding(50.dp)
                    .size(350.dp)
            )


            // Text Section
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Custom font
                val patuaOne = FontFamily(
                    Font(R.font.patua_one_regular, FontWeight.Normal)
                )

                Text(
                    text = "waste less.",
                    fontSize = 30.sp,
                    color = Color(0xFF8E3737),
                    style = TextStyle(
                        fontFamily = patuaOne,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    text = "save more.",
                    fontSize = 30.sp,
                    color = Color(0xFF8E3737),
                    style = TextStyle(
                        fontFamily = patuaOne,
                        fontWeight = FontWeight.Bold
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Recycle your food waste as you go!",
                    fontSize = 18.sp,
                    color = Color.Black,
                    style = TextStyle(
                        fontFamily = patuaOne,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }

        // Button Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Button(
                onClick = { navConroller.navigate("Home") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8E3737)) // Warna tombol
            ) {
                Text(
                    text = "Next >",
                    fontSize = 18.sp,
                    color = Color.White, // Warna teks di dalam tombol
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

// Preview Function
@Preview(showBackground = true)
@Composable
fun WasteLessScreenPreview() {
    EcoFoodTheme {
        WasteLessScreen(rememberNavController())
    }
}
