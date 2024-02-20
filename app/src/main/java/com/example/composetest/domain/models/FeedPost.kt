package com.example.composetest.domain.models

import com.example.composetest.R

data class FeedPost(
    val id: Int = 0,
    val communityName: String = "уволено",
    val publicationDate: String = "14:00",
    val avatarResId: Int = R.drawable.ic_launcher_foreground,
    val contentText: String = "dsflsdjfhkjsdfhjsdhfsdfsd",
    val contentImageResId: Int = R.drawable.ic_launcher_background,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(StatisticType.VIEWS, 966),
        StatisticItem(StatisticType.SHARES, 7),
        StatisticItem(StatisticType.COMMENTS, 8),
        StatisticItem(StatisticType.LIKES, 27)
    )
)
