package com.example.stockmate

import android.os.Bundle
import android.window.SplashScreen
import android.window.SplashScreenView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableInferredTarget
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockmate.ui.theme.StockMateTheme
import kotlinx.coroutines.delay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StockMateApp()
        }
    }
}

@Composable
fun StockMateApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(
                onFinished = {
                    navController.navigate("home") {
                        popUpTo("splash") {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable("home") {
            HomeScreen(navController)
        }
        composable("products") {
            Text("Product Screen",
                modifier = Modifier.padding(top = 450.dp, start = 120.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold)
        }
        composable("sales") {
            Text("Sales Screen",
                modifier = Modifier.padding(top = 450.dp, start = 120.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold)
        }
        composable("profile") {
            Text("Profile Screen",modifier = Modifier.padding(top = 450.dp, start = 120.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold)
        }
    }
}
    @Composable
    fun SplashScreen(onFinished: () -> Unit) {
        LaunchedEffect(Unit) {
            delay(2000)
            onFinished()
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "StockMate",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(R.drawable.splashscreen),
                contentDescription = "Stockmate Logo",
                modifier = Modifier.size(240.dp)
            )


            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Welcome to stockmate",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "StockMate", fontWeight = FontWeight.SemiBold,
                        fontSize = 22.sp,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF259468))
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Color(0xFFFCFDFD)) {
                NavigationBarItem(

                    selected = true, onClick = {

                        navController.navigate("home")
                    },
                    icon = {
                        Icon(imageVector = Icons.Default.Home,
                            contentDescription = "Home")
                    },
                    label = {
                        Text("Home")
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF009E60),
                        selectedTextColor =  Color(0xFF009E60),
                        unselectedIconColor = Color.DarkGray,
                        unselectedTextColor = Color.DarkGray
                    )
                )
                NavigationBarItem(

                    selected = false, onClick = {
                        navController.navigate("products")
                    },
                    icon = {
                        Icon(imageVector = Icons.Default.Inventory2,
                            contentDescription = "Products")
                    },
                    label = {
                        Text("Products")
                    },colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF009E60),
                        selectedTextColor =  Color(0xFF009E60),
                        unselectedIconColor = Color.DarkGray,
                        unselectedTextColor = Color.DarkGray
                    )
                )
                NavigationBarItem(

                    selected = false, onClick = {navController.navigate("sales")},
                    icon = {
                        Icon(imageVector = Icons.Default.BarChart,
                            contentDescription = "Sales")
                    },
                    label = {
                        Text("Sales")
                    },colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF009E60),
                        selectedTextColor =  Color(0xFF009E60),
                        unselectedIconColor = Color.DarkGray,
                        unselectedTextColor = Color.DarkGray
                    )
                )
                NavigationBarItem(

                    selected =false, onClick = {navController.navigate("profile")},
                    icon = {
                        Icon(imageVector = Icons.Default.Person,
                            contentDescription = "Profile")
                    },
                    label = {
                        Text("Profile")
                    },colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF009E60),
                        selectedTextColor =  Color(0xFF009E60),
                        unselectedIconColor = Color.DarkGray,
                        unselectedTextColor = Color.DarkGray
                    )
                )
            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(top = 4.dp, bottom = 8.dp, start = 3.dp, end = 3.dp)
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(vertical = 2.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE2E2E3))
            ) {
                Column(
                    modifier = Modifier.padding(24.dp)
                ) {
                    Text(
                        text = "Welcome to StockMate",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Smart Inventory Management",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.DarkGray
                    )
                }
            }

            Row(modifier = Modifier.fillMaxWidth()) {

                Card(
                    modifier = Modifier
                        .height(150.dp)
                        .weight(1f)
                        .padding(top = 10.dp, start = 5.dp, end = 5.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFA2EEDD))
                ) {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(R.drawable.producticon),
                            contentDescription = "Stockmate Logo",
                            modifier = Modifier.size(50.dp)
                                .align(Alignment.CenterHorizontally)
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "12",
                            fontSize = 15.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Total Products",
                            fontSize = 15.sp
                        )
                    }
                }
                Card(
                    modifier = Modifier.weight(1f)
                        .height(150.dp)
                        .padding(top = 10.dp, start = 5.dp, end = 5.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFA8484))
                ) {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally){
                        Image(
                            painter = painterResource(R.drawable.lowstock),
                            contentDescription = "Stockmate Logo",
                            modifier = Modifier.size(50.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "3",
                            fontSize = 15.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Low Stock",
                            fontSize = 15.sp
                        )

                    }
                }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Card(
                    modifier = Modifier.weight(1f)
                        .height(150.dp)
                        .padding(top = 10.dp, start = 5.dp, end = 5.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFAFD4F1))
                ) {
                    Column(modifier = Modifier
                        .fillMaxWidth().padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(R.drawable.totalsales),
                            contentDescription = "Stockmate Logo",
                            modifier = Modifier.size(50.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "$5231",
                            fontSize = 15.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Total Sales",
                            fontSize = 15.sp
                        )


                    }
                }
                Card(
                    modifier = Modifier.weight(1f)
                        .height(150.dp)
                        .padding(top = 10.dp, start = 5.dp, end = 5.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFDABDEC))
                ) {
                    Column(modifier = Modifier
                        .fillMaxWidth().padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(R.drawable.todaysales),
                            contentDescription = "Stockmate Logo",
                            modifier = Modifier.size(50.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "8",
                            fontSize = 15.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Today Sales",
                            fontSize = 15.sp
                        )


                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Quick Actions",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier =Modifier.padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier =Modifier.fillMaxWidth()) {
                Card(
                    modifier = Modifier.weight(1f)
                        .height(100.dp).padding(4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9))
                ) {

                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.addproduct),
                            contentDescription = "Stockmate Logo",
                            modifier = Modifier.size(60.dp)
                                .padding(top = 28.dp),

                        )

                        Text(
                            text = "Add Product",
                            fontSize = 15.sp, fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(top = 30.dp, start = 1.dp)
                        )
                    }
                }

                Card(
                    modifier = Modifier.weight(1f)
                        .height(100.dp)
                        .padding(4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9))
                ) {

                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.menugreen),
                            contentDescription = "Stockmate Logo",
                            modifier = Modifier.size(60.dp)
                                .padding(top = 28.dp,)
                        )
                        Text(
                            text = "View Products",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(top = 30.dp, start = 1.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(6.dp))
            Row(modifier =Modifier.fillMaxWidth()) {

                Card(modifier = Modifier.weight(1f)
                    .height(100.dp).padding(4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9))) {

                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.up),
                            contentDescription = "Stockmate Logo",
                            modifier = Modifier.size(60.dp)
                                .padding(top = 28.dp,)
                        )
                        Text(
                            text = "Stock In",
                            fontSize = 15.sp, fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(top = 30.dp, start = 1.dp)
                        )
                    }
                }
                Card(modifier = Modifier.weight(1f)
                    .height(100.dp)
                    .padding(4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9))) {

                   Row (modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically) {

                       Image(
                           painter = painterResource(R.drawable.down),
                           contentDescription = "Stockmate Logo",
                           modifier = Modifier.size(60.dp)
                               .padding(top = 28.dp),

                           )
                        Text(
                            text = "Stock Out",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(top = 30.dp, start = 1.dp)
                        )
                    }
                }
            }

                }
            }
        }





@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
   HomeScreen(navController = rememberNavController())
}