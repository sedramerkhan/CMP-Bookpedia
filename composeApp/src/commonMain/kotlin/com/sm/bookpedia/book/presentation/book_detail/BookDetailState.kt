package com.sm.bookpedia.book.presentation.book_detail

import com.sm.bookpedia.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = false,
    val isFavorite: Boolean = false,
    val book: Book? = null,
)