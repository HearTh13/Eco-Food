package com.prod.ecofood

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
fun CategoryPage(navController: NavController, item: Items, cart: Cart) {
    var categoryName by remember { mutableStateOf("All") }
    item.showCategory(categoryName)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(bottom = 50.dp)
        ){
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(16.dp)
            ) {

                // Header with Location
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {



                    Text(
                        text = "Delivered to:",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Image(
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "Location Icon",
                        modifier = Modifier
                            .size(24.dp)
                            .graphicsLayer(alpha = 0.5f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start){
                        Text(
                            text = "Yogyakarta, Indonesia",

                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Title
                Text(
                    text = "Showing your categories: $categoryName",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                // Category Image
                Image(
                    painter = painterResource(id = R.drawable.food2), // Replace with your banner image
                    contentDescription = "Category Banner",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.LightGray),
                    contentScale = ContentScale.Crop // Memastikan gambar memenuhi lebar dan tinggi tanpa meregang secara tidak proporsional
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Filter Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier
                            .horizontalScroll(rememberScrollState()),

                        ){
                        FilterButton(
                            label = "View All",
                            {
                                categoryName = "All"
                                item.showCategory(categoryName)
                            }
                        )
                        FilterButton(
                            label = "Grilled",
                            {
                                categoryName = "Grilled"
                                item.showCategory(categoryName)
                            }
                        )
                        FilterButton(
                            label = "Dessert",
                            {
                                categoryName = "Pastry or Dessert"
                                item.showCategory(categoryName)
                            }
                        )
                        FilterButton(
                            label = "Fast Food",
                            {
                                categoryName = "Fast Food"
                                item.showCategory(categoryName)
                            }
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.filter), // Replace with your filter icon
                        contentDescription = "Filter",
                        tint = Color.Gray,
                        modifier = Modifier.size(32.dp).clickable { /* Action */ }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Product List
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(item.show.size) { index ->
                        val product = item.show[index]
                        ProductCard(product = product) {
                            cart.addItem(product)
                        }
                    }
                }

                // Konten atas


            }
//            Spacer(modifier = Modifier.weight(1f)) // Untuk mendorong BottomNavBar ke bawah
        }
        BottomNavBar(
            navController = navController,
            navButton = 1, modifier = Modifier
            .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun FilterButton(label: String, action: () -> Unit) {
    Button(
        onClick = action,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5F5)),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(4.dp)
            .height(40.dp)
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ProductCard(product: MutableList<Any>, action: () -> Unit) {
    val numberF = NumberFormatter()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFF4E5), shape = RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(product[2] as Int), // Replace with actual product image
            contentDescription = "Product Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))

        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = product[0] as String,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = product[3] as String,
                fontSize = 14.sp,
                color = Color(0xFFFFC107)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = numberF.formatToId(product[1] as Int),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = action,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Add to Cart",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }


    }

}

// Sample Data
data class Product(
    val name: String,
    val description: String,
    val price: Int
)

val sampleProducts = listOf(
    Product("Cheese Burger", "★★★★★", 45000),
    Product("French Fries", "★★★★☆", 20000),
    Product("Fried Chicken Bucket", "★★★★★", 70000)
)

@Preview(showBackground = true)
@Composable
fun ProductCategoryPagePreview() {
    EcoFoodTheme {
        CategoryPage(navController = rememberNavController(), Items(), Cart())
    }
}
