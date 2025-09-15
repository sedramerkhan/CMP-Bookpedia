package com.sm.bookpedia.book.data.database

import androidx.room.RoomDatabaseConstructor

//expect means we want to have this constructor in our shared code
//to be able to initialize this database but the actual implementations of that
// is differs depending on the platform
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object BookDatabaseConstructor: RoomDatabaseConstructor<FavoriteBookDatabase> {
    override fun initialize(): FavoriteBookDatabase
}