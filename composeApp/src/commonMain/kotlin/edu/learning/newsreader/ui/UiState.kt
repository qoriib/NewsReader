package edu.learning.newsreader.ui

import edu.learning.newsreader.data.model.Article

sealed class UiState {
    object Loading : UiState()
    data class Success(val articles: List<Article>) : UiState()
    data class Error(val message: String) : UiState()
}
