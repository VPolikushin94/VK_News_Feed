package com.example.composetest.ui.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.composetest.R
import com.example.composetest.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    @StringRes val titleResId: Int,
    @DrawableRes val iconResId: Int
) {
    data object Home : NavigationItem(
        screen = Screen.NewsFeed,
        titleResId = R.string.main,
        iconResId = R.drawable.ic_home
    )

    data object Favorite : NavigationItem(
        screen = Screen.Favourite,
        titleResId = R.string.favorite,
        iconResId = R.drawable.ic_favourite
    )

    data object Profile : NavigationItem(
        screen = Screen.Profile,
        titleResId = R.string.profile,
        iconResId = R.drawable.ic_person
    )
}