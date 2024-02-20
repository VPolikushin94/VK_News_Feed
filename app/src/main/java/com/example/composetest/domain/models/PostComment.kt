package com.example.composetest.domain.models

import com.example.composetest.R

data class PostComment(
    val id: Int,
    val authorName: String = "Author",
    val authorAvatarId: Int = R.drawable.ic_launcher_foreground,
    val commentText: String = "comment text",
    val publicationDate: String = "14:00"
)
