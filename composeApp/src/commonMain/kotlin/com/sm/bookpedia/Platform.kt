package com.sm.bookpedia

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform