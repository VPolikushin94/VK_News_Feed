package com.example.composetest.navigation

sealed class Screen(
    val route: String
) {
    data object NewsFeed : Screen(ROUTE_NEWS_FEED)
    data object Favourite : Screen(ROUTE_FAVOURITE)
    data object Profile : Screen(ROUTE_PROFILE)

    private companion object {
        const val ROUTE_NEWS_FEED = "ROUTE_NEWS_FEED"
        const val ROUTE_FAVOURITE = "ROUTE_FAVOURITE"
        const val ROUTE_PROFILE = "ROUTE_PROFILE"
    }
}