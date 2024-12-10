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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prod.ecofood.ui.theme.EcoFoodTheme
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LogoToo(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC100))
            .clickable { navController.navigate("Category") },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val faceImage = painterResource(R.drawable.recycle)
        Image(
            painter = faceImage,
            contentDescription = "image",
            modifier = Modifier
                .padding(40.dp)
                .size(200.dp)
        )

        // Definisikan font PatuaOne
        val patuaOne = FontFamily(
            Font(R.font.patua_one_regular, FontWeight.Normal)
        )

        // Tampilkan teks dengan font kustom
        Text(
            text = "Waste less. Save more.",
            fontSize = 20.sp,
            color = Color(0xFF8E3737),
            style = TextStyle(
                fontFamily = patuaOne,
                fontWeight = FontWeight.Normal
            )
        )

        // Kolom untuk garis horizontal dan jarak
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

// Fungsi preview
@Preview(showBackground = true)
@Composable
fun LogoTooPreview() {
    EcoFoodTheme {
        LogoToo(rememberNavController())
    }
}
