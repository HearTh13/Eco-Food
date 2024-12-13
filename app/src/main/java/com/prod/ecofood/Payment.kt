package com.prod.ecofood

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
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
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ManualTransferScreen(navController: NavController, cart: Cart) {
    val clipboardManager: ClipboardManager = LocalClipboardManager.current
    var currentTime by remember { mutableStateOf(getCurrentTime()) }
    val format = NumberFormatter()

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000L)
            currentTime = getCurrentTime()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9FAFB))
            .padding(16.dp)
    ) {
        // Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Tombol Kembali",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Pembayaran",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF212121)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Manual Transfer Section
        Text(
            text = "Transfer Manual",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF212121)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Silakan transfer sebelum waktu berikut:",
            fontSize = 14.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color(0xFFFFE0E0), shape = RoundedCornerShape(8.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.jam),
                contentDescription = "Jam",
                modifier = Modifier.size(20.dp),
                tint = Color(0xFFFF5722)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = currentTime,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFF5722)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Bank Info Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFF4E5), shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.mandiri),
                        contentDescription = "Logo Bank",
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "Bank Mandiri",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(
                            text = "PT. MovieTckt Indonesia",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val accountNumber = "1234567890"
                    Text(
                        text = accountNumber,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.copy),
                        contentDescription = "Ikon Salin",
                        tint = Color.Gray,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                clipboardManager.setText(androidx.compose.ui.text.AnnotatedString(accountNumber))
                            }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Nominal Transfer Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFF4E5), shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Nominal Transfer",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = format.formatToId(cart.totalPrice),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.copy),
                    contentDescription = "Ikon Salin",
                    tint = Color.Gray,
                    modifier = Modifier.size(24.dp).clickable { }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Pay Now Button
        Button(
            onClick = { navController.navigate("Bought") },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),

            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.check),
                contentDescription = "Check Icon",
                modifier = Modifier.size(30.dp),

            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "OK",
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

fun getCurrentTime(): String {
    val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
    return sdf.format(Date())
}

@Preview(showBackground = true)
@Composable
fun PreviewManualTransferScreen() {
    EcoFoodTheme {
        ManualTransferScreen(rememberNavController(), Cart())
    }
}
