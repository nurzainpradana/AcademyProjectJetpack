package com.zainpradana.belajarkotlin.jetpack.academy.bookmark.viewmodel

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class BookmarkViewModelTest {

    private lateinit var viewModel: BookmarkViewModel

    @Before
    fun setUp() {
        viewModel = BookmarkViewModel()
    }

    @Test
    fun getBookmars() {
        val bookmarkEntities = viewModel.getBookmars()
        assertNotNull(bookmarkEntities)
        assertEquals(5, bookmarkEntities.size)
    }
}