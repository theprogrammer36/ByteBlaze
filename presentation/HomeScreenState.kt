package com.example.byteblaze.presentation


import com.example.byteblaze.domain.model.NewsArticle

data class HomeScreenState(
    val articles: List<NewsArticle> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val currentPage: Int = 1,
    val hasMorePages: Boolean = true
)