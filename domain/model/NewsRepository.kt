package com.example.byteblaze.domain.model


import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getArticles(page: Int, pageSize: Int): Flow<Result<List<NewsArticle>>>

    suspend fun getArticlesBySection(
        section: String,
        page: Int,
        pageSize: Int
    ): Flow<Result<List<NewsArticle>>>

    suspend fun searchArticles(
        query: String,
        page: Int,
        pageSize: Int
    ): Flow<Result<List<NewsArticle>>>
}