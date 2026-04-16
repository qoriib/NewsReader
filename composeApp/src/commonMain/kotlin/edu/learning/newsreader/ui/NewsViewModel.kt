package edu.learning.newsreader.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.learning.newsreader.data.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        fetchNews()
    }

    fun fetchNews() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            val result = repository.getTopHeadlines()
            result.onSuccess { articles ->
                _uiState.value = UiState.Success(articles)
            }.onFailure { exception ->
                _uiState.value = UiState.Error(exception.message ?: "Unknown Error")
            }
        }
    }
}
