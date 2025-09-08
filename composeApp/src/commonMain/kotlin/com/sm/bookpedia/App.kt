package com.sm.bookpedia

import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview

import com.sm.bookpedia.book.presentation.book_list.BookListScreenRoot
import com.sm.bookpedia.book.presentation.book_list.BookListViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {

    val viewModel = koinViewModel<BookListViewModel>()
    BookListScreenRoot(
        viewModel =viewModel,
        onBookClick = {

        }
    )
}