package com.sm.bookpedia

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.jetbrains.compose.ui.tooling.preview.Preview

import com.sm.bookpedia.book.presentation.book_list.BookListScreenRoot
import com.sm.bookpedia.book.presentation.book_list.BookListViewModel

@Composable
@Preview
fun App() {
    BookListScreenRoot (
        viewModel = remember {
            BookListViewModel()
        },
        onBookClick = {

        }
    )
}