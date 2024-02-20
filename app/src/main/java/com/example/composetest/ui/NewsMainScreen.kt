package com.example.composetest.ui


import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composetest.navigation.AppNavGraph
import com.example.composetest.ui.models.NavigationItem
import com.example.composetest.ui.view_model.NewsMainViewModel

@Composable
fun MainScreen(viewModel: NewsMainViewModel) {
    val navHostController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navHostController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favorite,
                    NavigationItem.Profile
                )
                items.forEach { item ->
                    BottomNavigationItem(
                        selected = currentRoute == item.screen.route,
                        onClick = { navHostController.navigate(item.screen.route) },
                        icon = {
                            Icon(
                                painter = painterResource(id = item.iconResId),
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = stringResource(id = item.titleResId))
                        },
                        selectedContentColor = MaterialTheme.colors.onPrimary,
                        unselectedContentColor = MaterialTheme.colors.onSecondary
                    )
                }
            }
        }
    ) {
        AppNavGraph(
            navHostController = navHostController,
            homeScreenContent = { HomeScreen(viewModel = viewModel, paddingValues = it) },
            favouriteScreenContent = { Text(text = "Favorites") },
            profileScreenContent = { Text(text = "Profile") }
        )
    }
}
