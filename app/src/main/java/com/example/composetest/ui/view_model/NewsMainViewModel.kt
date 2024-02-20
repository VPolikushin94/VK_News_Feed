package com.example.composetest.ui.view_model

import androidx.lifecycle.ViewModel
import com.example.composetest.domain.models.FeedPost
import com.example.composetest.domain.models.StatisticItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NewsMainViewModel : ViewModel() {

    private val mockFeedPost = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(FeedPost(id = it))
        }
    }

    private val _feedPosts = MutableStateFlow<List<FeedPost>>(mockFeedPost)
    val feedPosts: StateFlow<List<FeedPost>> = _feedPosts

    fun updateCount(feedPost: FeedPost, item: StatisticItem) {
        val oldPosts = feedPosts.value.toMutableList()
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
        _feedPosts.value = oldPosts.apply {
            replaceAll {
                if(it.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }
    }

    fun removePost(feedPost: FeedPost) {
        val oldPosts = feedPosts.value.toMutableList()
        oldPosts.remove(feedPost)
        _feedPosts.value = oldPosts
    }
}