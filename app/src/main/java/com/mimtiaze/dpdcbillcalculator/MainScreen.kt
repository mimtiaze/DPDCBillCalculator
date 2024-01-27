package com.mimtiaze.dpdcbillcalculator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mimtiaze.dpdcbillcalculator.screen.HomeScreen
import com.mimtiaze.dpdcbillcalculator.utility.Constants


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    
    NavHost(navController = navController,
        startDestination = Constants.SCREEN_HOME)
    {
        composable(Constants.SCREEN_HOME) {
            HomeScreen()
        }
    }
}