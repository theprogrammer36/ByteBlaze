package com.example.byteblaze.data


import com.example.byteblaze.data.api.ApiConstants
import com.example.byteblaze.data.api.GuardianApiService
import com.example.byteblaze.domain.model.NewsArticle
import com.example.byteblaze.domain.model.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val apiService: GuardianApiService
) : NewsRepository {

    override suspend fun getArticles(
        page: Int,
        pageSize: Int
    ): Flow<Result<List<NewsArticle>>> = flow {
        try {
            val response = apiService.getArticles(
                apiKey = ApiConstants.API_KEY,
                page = page,
                pageSize = pageSize
            )
            val articles = response.response.results.map { it.toDomain() }
            emit(Result.success(articles))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    override suspend fun getArticlesBySection(
        section: String,
        page: Int,
        pageSize: Int
    ): Flow<Result<List<NewsArticle>>> = flow {
        try {
            val response = apiService.getArticlesBySection(
                apiKey = ApiConstants.API_KEY,
                section = section,
                page = page,
                pageSize = pageSize
            )
            val articles = response.response.results.map { it.toDomain() }
            emit(Result.success(articles))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    override suspend fun searchArticles(
        query: String,
        page: Int,
        pageSize: Int
    ): Flow<Result<List<NewsArticle>>> = flow {
        try {
            val response = apiService.searchArticles(
                apiKey = ApiConstants.API_KEY,
                query = query,
                page = page,
                pageSize = pageSize
            )
            val articles = response.response.results.map { it.toDomain() }
            emit(Result.success(articles))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}