package com.sm.bookpedia

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.sm.bookpedia.book.data.network.KtorRemoteBookDataSource
import com.sm.bookpedia.book.data.repository.DefaultBookRepository
import org.jetbrains.compose.ui.tooling.preview.Preview

import com.sm.bookpedia.book.presentation.book_list.BookListScreenRoot
import com.sm.bookpedia.book.presentation.book_list.BookListViewModel
import com.sm.bookpedia.core.data.HttpClientFactory
import io.ktor.client.engine.HttpClientEngine

@Composable
@Preview
fun App(engine: HttpClientEngine) {
    BookListScreenRoot(
        viewModel = remember {
            BookListViewModel(
                bookRepository = DefaultBookRepository(
                    remoteBookDataSource = KtorRemoteBookDataSource(
                        httpClient = HttpClientFactory.create(
                            engine
                        )
                    )
                )
            )
        },
        onBookClick = {

        }
    )
}