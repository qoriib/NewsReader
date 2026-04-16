package edu.learning.newsreader.data.model

import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    val status: String? = null,
    val totalResults: Int? = null,
    val articles: List<Article> = emptyList()
)

@Serializable
data class Article(
    val title: String,
    val description: String?,
    val urlToImage: String?,
    val content: String? = null,
    val author: String? = null,
    val publishedAt: String? = null
)
