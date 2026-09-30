package com.pemmob.nafisah

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pemmob.nafisah.ui.screen.DaftarProductScreen
import com.pemmob.nafisah.ui.screen.DetailProductScreen
import com.pemmob.nafisah.ui.screen.HubungiKamiScreen
import com.pemmob.nafisah.ui.theme.JualanTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JualanTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "daftar_produk"
                ) {
                    // ===== Route 1: Daftar Produk =====
                    composable(route = "daftar_produk") {
                        DaftarProductScreen(navController = navController)
                    }

                    // ===== Route 2: Detail Produk (butuh productId) =====
                    composable(
                        route = "detail/{productId}",
                        arguments = listOf(
                            navArgument("productId") {
                                type = NavType.IntType
                            }
                        )
                    ) { backStackEntry ->
                        // ✅ FIX: hapus "key = " pada getInt
                        val productId = backStackEntry.arguments?.getInt("productId") ?: 0
                        DetailProductScreen(
                            productId = productId,
                            navController = navController
                        )
                    }

                    // ===== Route 3: Hubungi Kami =====
                    composable(route = "hubungi_kami") {
                        HubungiKamiScreen(navController = navController)
                    }
                }
            }
        }
    }
}