package com.sm.bookpedia.book.data.network

import com.sm.bookpedia.book.data.dto.BookWorkDto
import com.sm.bookpedia.book.data.dto.SearchResponseDto
import com.sm.bookpedia.core.domain.DataError
import com.sm.bookpedia.core.domain.Result


interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

    suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote>

}