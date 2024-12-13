package com.prod.ecofood

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.prod.ecofood.ui.theme.EcoFoodTheme

@Composable
fun Profile(navController: NavController){
    val navButton: Int = 2
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF4cc)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val faceImage = painterResource(R.drawable.pro)
        Image(
            painter = faceImage,
            contentDescription = "image",
            modifier = Modifier
                .padding(80.dp)
                .size(150.dp)
                .clip(CircleShape)
        )
        Text(
            text = "Herodina",
            fontSize = 20.sp
        )
        Column(
            modifier = Modifier
                .padding(40.dp)
//                .fillMaxSize()
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .height(2.dp)
            )
            Spacer(
                modifier = Modifier.padding(10.dp)
            )
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                val image = painterResource(R.drawable.ic_orders)
                Image(
                    painter = image,
                    contentDescription = "orders",
                    Modifier.size(30.dp)
                )
                Spacer(
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = "Orders",
                    fontSize = 15.sp
                )
            }
            Spacer(
                Modifier.padding(5.dp)
            )
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                val image = painterResource(R.drawable.ic_wallet)
                Image(
                    painter = image,
                    contentDescription = "orders",
                    Modifier.size(30.dp)
                )
                Spacer(
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = "ECO Wallet",
                    fontSize = 15.sp
                )
                Spacer(
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Rp 10.500,-",
                    fontSize = 15.sp
                )
            }
            Spacer(
                Modifier.padding(5.dp)
            )
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                val image = painterResource(R.drawable.ic_reviews)
                Image(
                    painter = image,
                    contentDescription = "orders",
                    Modifier.size(30.dp)
                )
                Spacer(
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = "Reviews",
                    fontSize = 15.sp
                )
            }
            Spacer(
                Modifier.padding(5.dp)
            )
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                val image = painterResource(R.drawable.ic_cart)
                Image(
                    painter = image,
                    contentDescription = "orders",
                    Modifier.size(30.dp)
                )
                Spacer(
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = "Cart",
                    fontSize = 15.sp
                )
            }
            Spacer(
                modifier = Modifier.padding(10.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .height(2.dp)
            )
            Spacer(
                Modifier.padding(25.dp)
            )
            Text(
                text = "Other Options",
                fontSize = 20.sp
            )
            Spacer(
                Modifier.padding(5.dp)
            )
            Text(
                text = "Sign Out",
                fontSize = 15.sp,
                color = Color(0xFF1D5C2E),
                modifier = Modifier.clickable { navController.navigate("StartUp") }
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        BottomNavBar(navController, navButton)
    }
}

@Preview(showBackground = true)
@Composable
fun ReviewProfile(){
    EcoFoodTheme {
        Profile(rememberNavController())
    }
}