package com.example.composetest.ui.view_model

import androidx.lifecycle.ViewModel
import com.example.composetest.domain.models.FeedPost
import com.example.composetest.domain.models.StatisticItem
import com.example.composetest.ui.models.NewFeedScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NewsFeedViewModel : ViewModel() {

    private val mockFeedPost = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(FeedPost(id = it))
        }
    }

    private val initialState = NewFeedScreenState.Posts(mockFeedPost)

    private val _screenState = MutableStateFlow<NewFeedScreenState>(initialState)
    val screenState: StateFlow<NewFeedScreenState> = _screenState

    fun updateCount(feedPost: FeedPost, item: StatisticItem) {
        val currentState = screenState.value
        if (currentState !is NewFeedScreenState.Posts) return

        val oldPosts = currentState.posts.toMutableList()
        val oldStatistics = feedPost.statistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        val newFeedPost = feedPost.copy(statistics = newStatistics)
        val newPosts = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }
        _screenState.value = NewFeedScreenState.Posts(newPosts)
    }

    fun removePost(feedPost: FeedPost) {
        val currentState = screenState.value
        if (currentState !is NewFeedScreenState.Posts) return

        val oldPosts = currentState.posts.toMutableList()
        oldPosts.remove(feedPost)
        _screenState.value = NewFeedScreenState.Posts(oldPosts)
    }
}