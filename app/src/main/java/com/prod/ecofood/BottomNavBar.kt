package com.prod.ecofood

import android.widget.RadioButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.prod.ecofood.ui.theme.EcoFoodTheme

@Composable
fun BottomNavBar(navController: NavController, navButton: Int){
    val colors: Array<Color> = arrayOf(
        Color(0xFFFFFFFF),  // White
        Color(0xFFFFFFFF),  // White
        Color(0xFFFFFFFF),  // White
        Color(0xFFFFFFFF)   // White
    )
    colors[navButton] = Color(0xFFFFC100)
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .background(colors[0], RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .clickable { navController.navigate("Home") }
        ){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(10.dp)
            ) {
                val image = painterResource(R.drawable.ic_home)
                Image(
                    painter = image,
                    contentDescription = "description",
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "Home"
                )
            }
        }
        Box(
            modifier = Modifier
                .background(colors[1], RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .clickable { navController.navigate("Message") }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp)
            ) {
                val image = painterResource(R.drawable.ic_category)
                Image(
                    painter = image,
                    contentDescription = "description",
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "Category"
                )
            }
        }
        Box(
            modifier = Modifier
                .background(colors[2], RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .clickable { navController.navigate("Profile") }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp)
            ) {
                val image = painterResource(R.drawable.ic_profile)
                Image(
                    painter = image,
                    contentDescription = "description",
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "Profile"
                )
            }
        }
        Box(
            modifier = Modifier
                .background(colors[3], RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .clickable { navController.navigate("Cart") }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp)
            ) {
                val image = painterResource(R.drawable.ic_cart)
                Image(
                    painter = image,
                    contentDescription = "description",
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "Cart"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavBarPreview(){
    EcoFoodTheme {
        BottomNavBar(rememberNavController(), 1)
    }
}