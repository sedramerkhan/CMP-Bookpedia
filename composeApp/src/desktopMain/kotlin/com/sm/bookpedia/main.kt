package com.sm.bookpedia

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.sm.bookpedia.di.initKoin

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "CMP-Bookpedia",
    ) {
        App()
    }
}