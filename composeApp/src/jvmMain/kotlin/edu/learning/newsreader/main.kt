package edu.learning.newsreader

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main(args: Array<String>) {
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "NewsReader",
        ) {
            App()
        }
    }
}
