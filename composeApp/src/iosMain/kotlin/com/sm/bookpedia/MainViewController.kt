package com.sm.bookpedia

import androidx.compose.ui.window.ComposeUIViewController
import com.sm.bookpedia.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }