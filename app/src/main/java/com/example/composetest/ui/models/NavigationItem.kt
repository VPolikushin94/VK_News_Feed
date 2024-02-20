package com.example.composetest.ui.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.composetest.R

sealed class NavigationItem(
    @StringRes val titleResId: Int,
    @DrawableRes val iconResId: Int
) {
    data object Home : NavigationItem(
        titleResId = R.string.main,
        iconResId = R.drawable.ic_home
    )

    data object Favorite : NavigationItem(
        titleResId = R.string.favorite,
        iconResId = R.drawable.ic_favorite
    )

    data object Profile : NavigationItem(
        titleResId = R.string.profile,
        iconResId = R.drawable.ic_person
    )
}