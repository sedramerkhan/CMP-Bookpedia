package com.sm.bookpedia.di

import com.sm.bookpedia.book.data.network.KtorRemoteBookDataSource
import com.sm.bookpedia.book.data.network.RemoteBookDataSource
import com.sm.bookpedia.book.data.repository.DefaultBookRepository
import com.sm.bookpedia.book.domain.BookRepository
import com.sm.bookpedia.book.presentation.book_list.BookListViewModel
import com.sm.bookpedia.core.data.HttpClientFactory

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module


expect val platformModule: Module


val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    viewModelOf(::BookListViewModel)

}