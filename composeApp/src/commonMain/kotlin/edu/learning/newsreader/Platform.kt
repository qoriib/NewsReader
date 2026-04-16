package edu.learning.newsreader

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform