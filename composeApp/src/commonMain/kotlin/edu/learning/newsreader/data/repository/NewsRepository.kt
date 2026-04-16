package edu.learning.newsreader.data.repository

import edu.learning.newsreader.data.model.Article
import edu.learning.newsreader.data.model.NewsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class NewsRepository(private val client: HttpClient) {
    
    private val apiKey = "8e1ee9136dfc46de815b11817121c6ca"
    private val baseUrl = "https://newsapi.org/v2"

    suspend fun getTopHeadlines(country: String = "us"): Result<List<Article>> {
        return try {
            val response: NewsResponse = client.get("$baseUrl/top-headlines") {
                parameter("country", country)
                parameter("apiKey", apiKey)
            }.body()
            
            if (response.status == "ok") {
                Result.success(response.articles)
            } else {
                Result.failure(Exception("Failed to fetch news: ${response.status}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
