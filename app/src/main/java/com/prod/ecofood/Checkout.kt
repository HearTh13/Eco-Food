package com.prod.ecofood

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.prod.ecofood.objects.Cart
import com.prod.ecofood.ui.theme.EcoFoodTheme
import com.prod.ecofood.utilities.NumberFormatter

@Composable
fun Checkout(navController: NavController, cart: Cart) {
    val numberF = NumberFormatter()
    var itemArray by remember { mutableStateOf(cart.arrays.toMutableList()) }
    var totalPrice by remember { mutableStateOf(cart.totalPrice) }
    var disc by remember { mutableStateOf(totalPrice - (totalPrice*8/100)) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        // Back Button Row with Icon
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow),
                contentDescription = "Back Button",
                tint = Color.Black,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { navController.popBackStack() }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Konfirmasi Pesanan",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Divider(color = Color.Gray, thickness = 1.dp)

        Spacer(modifier = Modifier.height(16.dp))

        // Address Section with Icon
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.location),
                contentDescription = "Location Icon",
                modifier = Modifier
                    .size(24.dp)
                    .graphicsLayer(alpha = 0.5f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Alamat Pengiriman: Jl. Contoh No.123, Yogyakarta",
                fontSize = 16.sp,
                color = Color.DarkGray
            )
        }

        Image(
            painter = painterResource(R.drawable.alamat2),
            contentDescription = "Address Image",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2f)
                .padding(vertical = 20.dp)
        )

        Divider(color = Color.Gray, thickness = 1.dp)

        Spacer(modifier = Modifier.height(16.dp))

        // Detail Barang Section
        Text(
            text = "Detail Barang:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        for (item in itemArray){
            Column(modifier = Modifier.padding(vertical = 8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(item[2] as Int),
                            contentDescription = "Gambar Barang",
                            modifier = Modifier.size(80.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = item[0] as String, fontSize = 16.sp)
                    }
                    Text(text = numberF.formatToId(item[1] as Int), fontSize = 16.sp)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Jumlah: "+item[3], fontSize = 16.sp)
                }
            }
        }

        Divider(color = Color.Gray, thickness = 1.dp)

        Spacer(modifier = Modifier.height(16.dp))

        // Metode Pembayaran Section
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.card),
                contentDescription = "Location Icon",
                modifier = Modifier
                    .size(24.dp)
                    .graphicsLayer(alpha = 0.5f) // Menurunkan opasitas gambar
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Metode Pembayaran: Transfer Mandiri",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Metode Pengiriman Section
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.shipping),
                contentDescription = "Location Icon",
                modifier = Modifier
                    .size(24.dp)
                    .graphicsLayer(alpha = 0.5f) // Menurunkan opasitas gambar
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Metode Pengiriman: Driver",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(vertical = 16.dp))

        // Detail Pembayaran Section
        Text(
            text = "Detail Pembayaran:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Column(modifier = Modifier.padding(vertical = 8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Harga Makanan", fontSize = 16.sp)
                Text(text = numberF.formatToId(totalPrice), fontSize = 16.sp)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Subtotal", fontSize = 16.sp)
                Text(text = numberF.formatToId(disc), fontSize = 16.sp)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total Pembayaran",
                    fontSize = 16.sp,
                    color = Color(0xFFFF9800),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = numberF.formatToId(disc),
                    fontSize = 16.sp,
                    color = Color(0xFFFF9800),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Checkout Button
        Button(
            onClick = {
                navController.navigate("Success")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Bayar Sekarang", fontSize = 18.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ReviewCheckout() {
    EcoFoodTheme {
        Checkout(rememberNavController(), Cart())
    }
}
