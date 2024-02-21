package com.example.composetest.ui.models

import com.example.composetest.domain.models.FeedPost
import com.example.composetest.domain.models.PostComment

sealed class CommentsScreenState {

    data object Initial : CommentsScreenState()
    data class Comments(val feedPost: FeedPost, val comments: List<PostComment>) : CommentsScreenState()
}