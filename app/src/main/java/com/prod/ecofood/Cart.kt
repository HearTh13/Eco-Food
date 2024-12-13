package com.prod.ecofood

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.prod.ecofood.objects.Cart
import com.prod.ecofood.objects.Items
import com.prod.ecofood.ui.theme.EcoFoodTheme
import com.prod.ecofood.utilities.NumberFormatter

const val TAG = "array"

@Composable
fun Cart(navController: NavController, cart: Cart){
    var itemArray by remember { mutableStateOf(cart.arrays.toMutableList()) }
    var totalPrice by remember { mutableStateOf(cart.totalPrice) }
    val numberUtil = NumberFormatter()
    val navButton: Int = 3
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFFC100))
                    .padding(12.dp)
            ) {
                Text(
                    text = "Cart",
                    fontSize = 28.sp
                )
                Spacer(Modifier.weight(1f))
                val image = painterResource(R.drawable.ic_cart)
                Image(
                    painter = image,
                    contentDescription = "Image",
                    modifier = Modifier.size(30.dp)
                )
            }
            Spacer(Modifier.padding(5.dp))
            Row {
                Text(
                    text = "Total Harga: "+numberUtil.formatToId(totalPrice),
                    modifier = Modifier.padding(15.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Clear Cart",
                    modifier = Modifier
                        .padding(15.dp)
                        .clickable {
                            cart.clearCart()
                            itemArray = cart.arrays.toMutableList()
                            totalPrice = cart.totalPrice
                        },
                    color = Color.Blue
                )
            }
            for (cartItem in itemArray){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFF4cc))
                        .padding(12.dp)
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.height(75.dp)
                    ) {
                        val image = painterResource(cartItem[2] as Int)
                        Image(
                            painter = image,
                            contentDescription = "Image",
                            modifier = Modifier.size(50.dp)
                        )
                        Spacer(modifier = Modifier.padding(10.dp))
                        Column {
                            Text(text = cartItem[0] as String)
                            Text(text = numberUtil.formatToId(cartItem[1] as Int))
                            Row {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(24.dp)
                                        .padding(2.dp)
                                        .background(Color(0xFFFFC100), RoundedCornerShape(bottomStart = 16.dp, topStart = 16.dp))
                                        .clickable {
                                            cart.subtractItem(cartItem)
                                            itemArray = cart.arrays
                                            totalPrice = cart.totalPrice
                                        }
                                ) {
                                    val image = painterResource(R.drawable.ic_back_button)
                                    Image(
                                        painter = image,
                                        contentDescription = "image",
                                        modifier = Modifier.size(12.dp)
                                    )
                                }
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .background(Color.White)
                                        .width(50.dp)
                                ){
                                    Text(text = cartItem[3].toString())
                                }
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(24.dp)
                                        .padding(2.dp)
                                        .background(Color(0xFFFFC100), RoundedCornerShape(bottomEnd = 16.dp, topEnd = 16.dp))
                                        .clickable {
                                            cart.addItemByOne(cartItem)
                                            itemArray = cart.arrays
                                            totalPrice = cart.totalPrice
                                        }
                                ) {
                                    val image = painterResource(R.drawable.ic_forward_button)
                                    Image(
                                        painter = image,
                                        contentDescription = "image",
                                        modifier = Modifier.size(12.dp)
                                    )
                                }
                            }
                        }
                        Spacer(Modifier.weight(1f))
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(50.dp)
                                .background(Color.White)
                                .clickable {
                                    cart.removeItem(cartItem)
                                    itemArray = cart.arrays
                                    totalPrice = cart.totalPrice
                                }
                        ){
                            val image = painterResource(R.drawable.ic_delete)
                            Image(
                                painter = image,
                                contentDescription = "Image",
                                Modifier.size(20.dp)
                            )
                        }

                    }
                }
            }
            if (itemArray.isNotEmpty()){
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("Checkout")
                        }
                        .border(
                            width = 2.dp,
                            brush = SolidColor(Color.Black),
                            shape = RoundedCornerShape(8.dp)
                        )
                ){
                    Text("Proceed to Checkout")
                }
            }
        }
        BottomNavBar(
            navController = navController,
            navButton = navButton,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun CartPreview(){
    EcoFoodTheme {
        Cart(rememberNavController(), Cart())
    }
}