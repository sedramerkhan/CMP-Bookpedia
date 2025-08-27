package com.sm.bookpedia.book.domain

import com.sm.bookpedia.core.domain.DataError
import com.sm.bookpedia.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>


}