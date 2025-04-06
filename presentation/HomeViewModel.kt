package com.example.byteblaze.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.byteblaze.domain.model.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenState())
    val state: StateFlow<HomeScreenState> = _state.asStateFlow()

    init {
        loadArticles()
    }

    fun loadArticles(forceRefresh: Boolean = false) {
        if (forceRefresh) {
            _state.update { it.copy(currentPage = 1, articles = emptyList()) }
        }

        if (!forceRefresh && _state.value.isLoading) return

        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }

            getArticlesUseCase(page = _state.value.currentPage)
                .collect { result ->
                    result.fold(
                        onSuccess = { articles ->
                            _state.update { currentState ->
                                currentState.copy(
                                    articles = if (currentState.currentPage == 1) {
                                        articles
                                    } else {
                                        currentState.articles + articles
                                    },
                                    isLoading = false,
                                    hasMorePages = articles.isNotEmpty(),
                                    currentPage = currentState.currentPage + 1
                                )
                            }
                        },
                        onFailure = { exception ->
                            _state.update { it.copy(
                                isLoading = false,
                                error = exception.message
                            )}
                        }
                    )
                }
        }
    }

    fun loadMoreArticles() {
        if (!_state.value.isLoading && _state.value.hasMorePages) {
            loadArticles()
        }
    }

    fun refresh() {
        loadArticles(forceRefresh = true)
    }
}