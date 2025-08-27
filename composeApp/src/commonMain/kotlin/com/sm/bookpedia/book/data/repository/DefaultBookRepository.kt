package com.sm.bookpedia.book.data.repository

import androidx.sqlite.SQLiteException
import com.sm.bookpedia.book.data.mapper.toBook
import com.sm.bookpedia.book.data.network.RemoteBookDataSource
import com.sm.bookpedia.book.domain.Book
import com.sm.bookpedia.book.domain.BookRepository
import com.sm.bookpedia.core.domain.DataError
import com.sm.bookpedia.core.domain.Result
import com.sm.bookpedia.core.domain.map



class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
): BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }


}