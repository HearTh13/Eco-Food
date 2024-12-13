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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.prod.ecofood.objects.Cart
import com.prod.ecofood.objects.Items
import com.prod.ecofood.ui.theme.EcoFoodTheme
import com.prod.ecofood.utilities.NumberFormatter

@Composable
fun Home(navController: NavController, items: Items, cart: Cart){
    var notif: Int by remember { mutableStateOf(0) }

    val updateNotif: (Int) -> Unit = { newNotif ->
        notif = newNotif
    }
    Box {
        Column(modifier = Modifier.fillMaxSize().background(Color.White).verticalScroll(
            rememberScrollState()
        )) {
            Header()
            Discount()
            Categories(navController, items)
            TopFoods(navController, items, cart, updateNotif, notif)
            Spacer(modifier = Modifier.height(50.dp))
        }
        BottomNavBar(
            navController = navController,
            navButton = 0,
            notif = notif,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Hello, Herodina!",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
            Row{
                Image(
                    painter = painterResource(id = R.drawable.location),
                    contentDescription = "Location Icon",
                    modifier = Modifier
                        .size(17.dp)
                        .graphicsLayer(alpha = 0.5f)
                )
                Text(
                    text = "Yogyakarta, Indonesia",
                    style = TextStyle(fontSize = 14.sp, color = Color.Gray)
                )


            }
        }
        Image(
            painter = painterResource(R.drawable.pro),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(70.dp) // Define the size of the circle
                .clip(CircleShape) // Clip the image to a circular shape
                .background(Color.LightGray) // Optional: Add a background color if needed
        )
    }
}

@Composable
fun Discount() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFFFFD700), shape = MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Enjoy the Discount of the day", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { /* Handle Click */ }) {
                Text("Check it")
            }
        }
    }
}

@Composable
fun Categories(navController: NavController, items: Items) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Categories", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CategoriesItem("Meat", R.drawable.meat, {
                items.category = "Meat"
                navController.navigate("Category")
            }) // Replace with actual drawable resources
            CategoriesItem("Cake", R.drawable.dessert, {
                items.category = "Cake"
                navController.navigate("Category")
            })
            CategoriesItem("Fast Food", R.drawable.fast_food, {
                items.category = "Fast Food"
                navController.navigate("Category")
            })
            CategoriesItem("Snack", R.drawable.snack, {
                items.category = "Snack"
                navController.navigate("Category")
            })
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CategoriesItem("Pastry or Dessert", R.drawable.grill, {
                items.category = "Pastry or Dessert"
                navController.navigate("Category")
            })
            CategoriesItem("Vegan", R.drawable.vegan, {
                items.category = "Vegan"
                navController.navigate("Category")
            })
            CategoriesItem("International Food", R.drawable.indonesian, {
                items.category = "International Food"
                navController.navigate("Category")
            })
            CategoriesItem("Drinks", R.drawable.drinks, {
                items.category = "Drinks"
                navController.navigate("Category")
            })
        }
    }
}

@Composable
fun CategoriesItem(name: String, imageRes: Int, action:() -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .width(75.dp)
            .height(120.dp)
            .clickable{ action() }
    ) {
        // Image with Circle Shape
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape) // Clip the image into a circle
                .background(Color.LightGray) // Optional background color
        )
        Text(
            text = name,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun TopFoods(navController: NavController, items: Items, cart: Cart, updateNotif: (Int) -> Unit, notif: Int) {
    val array by remember { mutableStateOf(items.arrays) }
    val format = NumberFormatter()
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Top Foods", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))
            Text(
                text = "See all",
                modifier = Modifier
                    .clickable {
                        items.category = "All"
                        navController.navigate("Category")
                    },
                color = Color.Blue
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            array.chunked(3).forEach { rowItems -> // Chunk the list into groups of 3 (columns)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    rowItems.forEach { item ->
                        Card(
                            modifier = Modifier
                                .weight(1f) // Equal weight for columns
                                .height(180.dp)
                                .shadow(8.dp),
                            shape = RoundedCornerShape(8.dp),
//                            elevation = 10.dp
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.White, RoundedCornerShape(8.dp))
                                    .clickable {
                                        updateNotif(notif + 1)
                                        cart.addItem(item)
                                    }
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(8.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    val imagePainter = painterResource(id = item[2] as Int) // Safe to cast as Int
                                    Image(
                                        painter = imagePainter,
                                        contentDescription = item[0] as? String ?: "Image",
                                        modifier = Modifier
                                            .size(64.dp)
                                            .background(Color.White, RoundedCornerShape(8.dp)) // Set image background to white
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = item[0] as String,
                                        fontSize = 12.sp,
                                        textAlign = TextAlign.Center,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = format.formatToId(item[1] as Int),
                                        fontSize = 12.sp,
                                        color = Color.Gray,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHome(){
    EcoFoodTheme {
        Home(rememberNavController(), Items(), Cart())
    }
}