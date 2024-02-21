package com.example.composetest.ui.models

import com.example.composetest.domain.models.FeedPost

sealed class NewFeedScreenState {

    data class Posts(val posts: List<FeedPost>) : NewFeedScreenState()
}