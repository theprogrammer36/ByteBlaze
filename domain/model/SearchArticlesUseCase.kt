package com.example.byteblaze.domain.model



import com.example.byteblaze.domain.model.NewsArticle
import com.example.byteblaze.domain.model.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchArticlesUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(
        query: String,
        page: Int = 1,
        pageSize: Int = 20
    ): Flow<Result<List<NewsArticle>>> {
        return repository.searchArticles(query, page, pageSize)
    }
}